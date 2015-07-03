# Introduction #

Every attempt will be made to keep new versions of Sigmah backwards compatible with SQL databases created with earlier versions of Sigmah/ActivityInfo, but sometimes there will be a need for breaking changes. These can be found here.

All SQL commands below should be able to be runned on PostgreSQL database. Ideally, they should be written respecting the ANSI SQL norm.


## Remarks for developers in need to change the database model ##

Each time a developer needs to change the database, he should do the following:
  1. go through the database naming policy to know how he should call the new columns/tables he wants to create _(database naming policy should come soon...)_
  1. modify the graphical wiki schema of the database according to your change on TableListing
  1. modified the [trunk/scripts/sql](http://code.google.com/p/sigma-h/source/browse/#svn%2Ftrunk%2Fscripts%2Fsql) files of the MinimumDataKit to be sure that the fresh installation will have installation scripts which are up to date
  1. modified the wiki page below with the following rule: give the SQL commands to modify the structure of the database... and the data which may need to me updated according to your schema modification

# Release 2.0 #

## 1. Schema changes ##

```
-- Add table for storing the password expiration policy of an organization (issue #438 / #517)
-- ------
CREATE TABLE password_expiration_policy
(
  id bigint NOT NULL,
  policy_type character varying(255),
  reference_date date,
  frequency integer,
  reset_for_new_users boolean NOT NULL,
  organization_id integer NOT NULL,
  CONSTRAINT password_expiration_policy_pkey PRIMARY KEY (id),
  CONSTRAINT fk2fb477b2f85c2c3c FOREIGN KEY (organization_id)
      REFERENCES organization (id_organization) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Default password expiration policy (with no automatic reset set)
INSERT INTO password_expiration_policy (id, policy_type, reset_for_new_users, organization_id) SELECT nextval('hibernate_sequence'), 'NEVER', false, MAX(id_organization) FROM organization;



-- Add column to store the last password change of an user. (issue #438 / #517)
-- ------
ALTER TABLE UserLogin ADD COLUMN last_password_change timestamp without time zone;



-- Add columns to store the start date of maintenance periods. (issue #419)
-- ------
ALTER TABLE flexible_element ADD COLUMN creation_date timestamp without time zone not null default current_timestamp;

ALTER TABLE project_model ADD COLUMN date_maintenance timestamp without time zone;
ALTER TABLE org_unit_model ADD COLUMN date_maintenance timestamp without time zone;

ALTER TABLE flexible_element ADD COLUMN is_disabled boolean default false;
ALTER TABLE question_choice_element ADD COLUMN is_disabled boolean default false;


-- Adds tables for managing reminders and monitored points history  (issue #550)
-- ------
CREATE TABLE reminder_history (
	id_reminder_history integer PRIMARY KEY,
	generated_date timestamp without time zone NOT NULL,
	id_reminder integer REFERENCES reminder NOT NULL,
	id_user integer NOT NULL,
	value text,
	change_type character varying(255) NOT NULL
);

CREATE TABLE monitored_point_history (
	id_monitored_point_history integer PRIMARY KEY,
	generated_date timestamp without time zone NOT NULL,
	id_monitored_point integer REFERENCES monitored_point NOT NULL,
	id_user integer NOT NULL,
	value text,
	change_type character varying(255) NOT NULL
);


-- Adds tables for managing the flexibility of budget element and sets by default the planned and spent budget  (issue #386)
-- ------

CREATE TABLE budget_element
(
  id_flexible_element bigint NOT NULL,
  id_ratio_divisor bigint,
  id_ratio_dividend bigint,
  CONSTRAINT budget_element_pkey PRIMARY KEY (id_flexible_element),
  CONSTRAINT fk1ba06002a82c370 FOREIGN KEY (id_flexible_element)
      REFERENCES default_flexible_element (id_flexible_element) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE budget_sub_field
(
  id_budget_sub_field bigint NOT NULL,
  label character varying(255),
  id_budget_element bigint NOT NULL,
  fieldorder integer,
  type character varying(255),
  CONSTRAINT budget_sub_field_pkey PRIMARY KEY (id_budget_sub_field),
  CONSTRAINT fkc12629c1a251b09 FOREIGN KEY (id_budget_element)
      REFERENCES budget_element (id_flexible_element) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE budget_element ADD  CONSTRAINT fk1ba0600222f4f59 FOREIGN KEY (id_ratio_divisor)
      REFERENCES budget_sub_field (id_budget_sub_field) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
ALTER TABLE budget_element ADD  CONSTRAINT fk1ba06002a2a3285a FOREIGN KEY (id_ratio_dividend)
      REFERENCES budget_sub_field (id_budget_sub_field) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  

INSERT INTO budget_element (id_flexible_element)
	SELECT id_flexible_element FROM default_flexible_element WHERE default_flexible_element.type = 'BUDGET' AND default_flexible_element.id_flexible_element NOT IN (SELECT budget_element.id_flexible_element FROM budget_element );
INSERT INTO budget_sub_field (id_budget_sub_field,label, id_budget_element, fieldorder, type) 
			SELECT nextval('hibernate_sequence'), NULL, budget_element.id_flexible_element, 0, 'RECEIVED' FROM  budget_element;
INSERT INTO budget_sub_field (id_budget_sub_field,label, id_budget_element, fieldorder, type) 
			SELECT nextval('hibernate_sequence'), NULL, budget_element.id_flexible_element, 0, 'SPENT' FROM  budget_element;
INSERT INTO budget_sub_field (id_budget_sub_field,label, id_budget_element, fieldorder, type) 
			SELECT nextval('hibernate_sequence'), NULL, budget_element.id_flexible_element, 0, 'PLANNED' FROM  budget_element;
	UPDATE budget_element  SET id_ratio_divisor = bsf.id_budget_sub_field FROM budget_sub_field bsf WHERE  id_flexible_element =  bsf.id_budget_element AND bsf.type = 'PLANNED';
	UPDATE budget_element  SET id_ratio_dividend = bsf.id_budget_sub_field FROM budget_sub_field bsf WHERE  id_flexible_element =  bsf.id_budget_element AND bsf.type = 'SPENT';


-- Deletes all entries from the AdminEntity table which contains only admin entities from the Democratic Republic of the Congo 
-- ------

DELETE FROM adminentity;


-- Set all users as active by default (issue #771)
-- ------
ALTER TABLE UserLogin ALTER COLUMN active SET default true;



-- Add column for the main site
-- ------
ALTER TABLE project ADD COLUMN mainsite int;

-- 
-- Add column for comment in the history token table.
-- ------
ALTER TABLE history_token ADD comment varchar(255);



-- Add tables to manage importation scheme (importation frameworks)
-- ------

CREATE TABLE importation_scheme
(
  sch_id bigint NOT NULL,
  datedeleted timestamp without time zone,
  sch_file_format character varying(255) NOT NULL,
  sch_first_row integer,
  sch_import_type character varying(255) NOT NULL,
  sch_name character varying(255) NOT NULL,
  sch_sheet_name character varying(255),
  CONSTRAINT importation_scheme_pkey PRIMARY KEY (sch_id )
);


CREATE TABLE importation_scheme_model
(
  sch_mod_id bigint NOT NULL,
  datedeleted timestamp without time zone,
  sch_id bigint NOT NULL,
  org_unit_model_id integer,
  id_project_model bigint,
  CONSTRAINT importation_scheme_model_pkey PRIMARY KEY (sch_mod_id ),
  CONSTRAINT fk_cgrmoq07kxyggtnldsvlwjqcs FOREIGN KEY (id_project_model)
      REFERENCES project_model (id_project_model) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ckwexvghil94ha4ct8b1wepxq FOREIGN KEY (org_unit_model_id)
      REFERENCES org_unit_model (org_unit_model_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_prpi3dmykj4nbdeyk3dhb51jn FOREIGN KEY (sch_id)
      REFERENCES importation_scheme (sch_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE importation_scheme_variable
(
  var_id bigint NOT NULL,
  datedeleted timestamp without time zone,
  var_name character varying(255) NOT NULL,
  var_reference character varying(255) NOT NULL,
  sch_id bigint NOT NULL,
  CONSTRAINT importation_scheme_variable_pkey PRIMARY KEY (var_id ),
  CONSTRAINT fk_khgoedwqkg3au5a2o3fe4g398 FOREIGN KEY (sch_id)
      REFERENCES importation_scheme (sch_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE importation_scheme_variable_flexible_element
(
  var_fle_id bigint NOT NULL,
  datedeleted timestamp without time zone,
  var_fle_is_key boolean,
  id_flexible_element bigint NOT NULL,
  sch_mod_id bigint NOT NULL,
  var_id bigint,
  CONSTRAINT importation_scheme_variable_flexible_element_pkey PRIMARY KEY (var_fle_id ),
  CONSTRAINT fk_kr8tjw9mvseef9x0il6dojoh9 FOREIGN KEY (sch_mod_id)
      REFERENCES importation_scheme_model (sch_mod_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_nbgxlc3whl76ws07c99f70r6n FOREIGN KEY (var_id)
      REFERENCES importation_scheme_variable (var_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_q4la1it8wgg6nkosxi6rpd4cp FOREIGN KEY (id_flexible_element)
      REFERENCES flexible_element (id_flexible_element) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE importation_scheme_variable_budget_element
(
  var_fle_id bigint NOT NULL,
  CONSTRAINT importation_scheme_variable_budget_element_pkey PRIMARY KEY (var_fle_id ),
  CONSTRAINT fk_eu352p1mmft8pwwyylmwe63q8 FOREIGN KEY (var_fle_id)
      REFERENCES importation_scheme_variable_flexible_element (var_fle_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE importation_variable_budget_sub_field
(
  id_budget_sub_field bigint NOT NULL,
  var_id bigint NOT NULL,
  var_fle_id bigint NOT NULL,
  CONSTRAINT importation_variable_budget_sub_field_pkey PRIMARY KEY (id_budget_sub_field , var_id , var_fle_id ),
  CONSTRAINT fk_dfeq1vnw6d3ooeqf1stt4x276 FOREIGN KEY (var_id)
      REFERENCES importation_scheme_variable (var_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ms0uq981iysge90gt1o3pf40q FOREIGN KEY (var_fle_id)
      REFERENCES importation_scheme_variable_budget_element (var_fle_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_og2mv36vlu4uu885yrpnhbl2q FOREIGN KEY (id_budget_sub_field)
      REFERENCES budget_sub_field (id_budget_sub_field) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Core version element table
-- -----

CREATE TABLE core_version_element
(
  id_flexible_element int primary key
);


-- Add column name in amendement (project core)
-- --------------------------------------------
ALTER TABLE amendment ADD COLUMN name character varying(255);



-- Add column for the core version
-- --------------------------------
ALTER TABLE history_token ADD core_version int;



-- Add column for disabling flexible elements
-- ------
ALTER TABLE flexible_element ADD disabled_date timestamp;

```

## 2. Existing data updates ##

**After the schema is updated**, in order to update the existing data, the following request has to be applied (request required because of the issue [0000386: Flexible budget field](http://www.sigmah.org/issues/view.php?id=386) which lets user modify the budget sub fields)

```
-- Add South Sudan newest country in Sigmah list of countries
INSERT INTO Country (CountryId, x1, x2, y1, y2, ISO2, Name) VALUES (495, -180, 180, -90, 180, 'SS', 'South Sudan');

-- Updates all project model existing default fields to set them as part of project core (issue #167) (but not orgunit default fields)
update flexible_element
set amendable = TRUE
where id_flexible_element in 
	(select dfe.id_flexible_element 
	from default_flexible_element dfe
	where dfe.id_flexible_element not in 
		(select id_flexible_element 
		from layout_constraint lc
			inner join layout_group lg on lg.id_layout_group = lc.id_layout_group
			inner join org_unit_details oud on oud.id_layout = lg.id_layout)
	);


-- Updates existing users 'last password change' with current timestamp (issue #438 / #517)
-- ------
UPDATE UserLogin SET last_password_change = current_timestamp;



-- Updates existing global permissions to the new hierarchy of privileges (issue #616 and related)
-- ------
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'CREATE_TEST_PROJECT', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'REMOVE_PROJECT_FILE', p.id_profile FROM global_permission p WHERE p.permission='REMOVE_FILE';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'REMOVE_ORG_UNIT_FILE', p.id_profile FROM global_permission p WHERE p.permission='REMOVE_FILE';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'LOCK_PROJECT', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'VIEW_PROJECT_AGENDA', p.id_profile FROM global_permission p WHERE p.permission='VIEW_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_PROJECT_AGENDA', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';

INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'VIEW_LOGFRAME', p.id_profile FROM global_permission p WHERE p.permission='VIEW_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_LOGFRAME', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'VIEW_INDICATOR', p.id_profile FROM global_permission p WHERE p.permission='VIEW_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'VIEW_MAPTAB', p.id_profile FROM global_permission p WHERE p.permission='VIEW_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_MAIN_SITE', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_SITES', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_INDICATOR', p.id_profile FROM global_permission p WHERE p.permission='VIEW_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_INDICATOR', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';

INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_OWN_REMINDERS', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_ALL_REMINDERS', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';

INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'RELATE_PROJECT', p.id_profile FROM global_permission p WHERE p.permission='EDIT_PROJECT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_ORG_UNIT', p.id_profile FROM global_permission p WHERE p.permission='MANAGE_UNIT';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'REMOVE_ORG_UNIT_FILE', p.id_profile FROM global_permission p WHERE p.permission='REMOVE_FILE';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'VIEW_ORG_UNIT_AGENDA', p.id_profile FROM profile p WHERE p.id_profile not in (select id_profile from global_permission where permission='VIEW_ORG_UNIT_AGENDA');
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'EDIT_ORG_UNIT_AGENDA', p.id_profile FROM profile p WHERE p.id_profile not in (select id_profile from global_permission where permission='EDIT_ORG_UNIT_AGENDA');
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_USERS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_ORG_UNITS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_PROJECT_MODELS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_ORG_UNIT_MODELS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_REPORT_MODELS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_CATEGORIES', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_IMPORTATION_SCHEMES', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'MANAGE_SETTINGS', p.id_profile FROM global_permission p WHERE p.permission='VIEW_ADMIN';

INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'CHANGE_PASSWORD', p.id_profile FROM profile p WHERE p.id_profile not in (select id_profile from global_permission where permission='CHANGE_PASSWORD');
DELETE FROM global_permission p WHERE p.permission='MANAGE_UNIT';
DELETE FROM global_permission p WHERE p.permission='REMOVE_FILE';
DELETE FROM global_permission p WHERE p.permission='MANAGE_USER';
DELETE FROM global_permission p WHERE p.permission='VIEW_AGENDA';
DELETE FROM global_permission p WHERE p.permission='EDIT_AGENDA';

-- Updates history_token and value to table to fit the new structure of a budget element (issue #386)
-- ------
UPDATE history_token SET value = planned_budget_id || '%' || coalesce(budgetValues[1], '0.0') || '~' || received_budget_id || '%' || coalesce(budgetValues[2], '0.0')  || '~' || spent_budget_id || '%' ||  coalesce(budgetValues[3], '0.0') 
FROM (
	SELECT value, string_to_array(value, '~') AS budgetValues, flexible_element.id_flexible_element, id_history_token,
		planned.id_budget_sub_field  AS planned_budget_id,
		spent.id_budget_sub_field    AS spent_budget_id,
		received.id_budget_sub_field AS received_budget_id
	FROM history_token AS ht
	INNER JOIN flexible_element ON ( flexible_element.id_flexible_element = ht.id_element )
	LEFT  JOIN budget_sub_field AS planned  ON ( planned.id_budget_element = flexible_element.id_flexible_element  AND planned.type = 'PLANNED' )
	LEFT  JOIN budget_sub_field AS spent    ON ( spent.id_budget_element = flexible_element.id_flexible_element    AND spent.type = 'SPENT' )
	LEFT  JOIN budget_sub_field AS received ON ( received.id_budget_element = flexible_element.id_flexible_element AND received.type = 'RECEIVED' )
	WHERE flexible_element.id_flexible_element IN (Select id_flexible_element from budget_element)
) AS ssrequete
WHERE history_token.id_history_token = ssrequete.id_history_token;


INSERT INTO value (id_value, id_project, action_last_modif, date_last_modif, value, id_flexible_element, id_user_last_modif)
SELECT nextval('hibernate_sequence'), ht.id_project, CASE change_type WHEN 'EDIT' THEN 'U' ELSE 'C' END, history_date, value, ht.id_element, id_user
FROM history_token AS ht JOIN ( SELECT history_token.id_project, history_token.id_element, MAX (id_history_token) AS max_history_id FROM history_token GROUP BY id_project, id_element) AS requete
  ON requete.id_project = ht.id_project AND requete.id_element = ht.id_element AND requete.max_history_id = ht.id_history_token
WHERE (ht.id_project, ht.id_element) NOT IN (SELECT id_project, id_flexible_element FROM value) AND ht.id_element IN (SELECT id_flexible_element FROM budget_element);



-- Set all users as active by default (issue #771)
-- ------
UPDATE UserLogin SET active = true WHERE active is null;





```

# Release 1.2 #

## 1. Schema changes ##

```

-- Add the exportable preferences columns to the fields table and the required new tables (issue #388)
-- ------

-- POSTGRESQL
ALTER TABLE flexible_element ADD COLUMN exportable BOOLEAN NOT NULL DEFAULT TRUE;
ALTER TABLE flexible_element ADD COLUMN globally_exportable BOOLEAN NOT NULL DEFAULT TRUE;


-- MYSQL
ALTER TABLE flexible_element ADD exportable bit(1) NOT NULL DEFAULT b'1';
ALTER TABLE flexible_element ADD globally_exportable bit(1) NOT NULL DEFAULT b'1';


-- Add tables and basic default settings for Global Export (issue #388)
-- ------

-- tables in POSTGRESQL
CREATE TABLE global_export (
    id bigint NOT NULL,
    generated_date timestamp without time zone NOT NULL,
    organization_id integer NOT NULL
);

CREATE TABLE global_export_content (
    id bigint NOT NULL,
    csv_content text,
    project_model_name character varying(8192) NOT NULL,
    global_export_id bigint NOT NULL
);

CREATE TABLE global_export_settings (
    id bigint NOT NULL,
    auto_delete_frequency integer,
    auto_export_frequency integer,
    default_organization_export_format character varying(255),
    export_format character varying(255),
    last_export_date timestamp without time zone,
    locale_string character varying(4) NOT NULL,
    organization_id integer NOT NULL
);

ALTER TABLE ONLY global_export_content
    ADD CONSTRAINT global_export_content_pkey PRIMARY KEY (id);

ALTER TABLE ONLY global_export
    ADD CONSTRAINT global_export_pkey PRIMARY KEY (id);

ALTER TABLE ONLY global_export_settings
    ADD CONSTRAINT global_export_settings_pkey PRIMARY KEY (id);

ALTER TABLE ONLY global_export_settings
    ADD CONSTRAINT fk2fb477b2f85c2c3c FOREIGN KEY (organization_id) REFERENCES organization(id_organization);

ALTER TABLE ONLY global_export
    ADD CONSTRAINT fk9e763fd0f85c2c3c FOREIGN KEY (organization_id) REFERENCES organization(id_organization);

ALTER TABLE ONLY global_export_content
    ADD CONSTRAINT fkdca84b0af33647b9 FOREIGN KEY (global_export_id) REFERENCES global_export(id);




-- POSTGRESQL
INSERT INTO global_export_settings(id, auto_delete_frequency, auto_export_frequency, default_organization_export_format, export_format, last_export_date, locale_string, organization_id)
SELECT nextval('hibernate_sequence'), NULL, NULL, 'XLS', 'XLS', NULL, 'fr', id_organization FROM organization;

-- MYSQL
INSERT INTO global_export_settings(auto_delete_frequency, auto_export_frequency, default_organization_export_format, export_format, last_export_date, locale_string, organization_id)
SELECT NULL, NULL, 'XLS', 'XLS', NULL, 'fr', id_organization FROM organization;

-- Changes the date type columns to timestamp to avoid time difference (issue #463)
-- ------

-- POSTGRESQL
ALTER TABLE userdatabase ALTER COLUMN startdate TYPE TIMESTAMP;
ALTER TABLE project ALTER COLUMN end_date TYPE TIMESTAMP;
ALTER TABLE project ALTER COLUMN close_date TYPE TIMESTAMP;

ALTER TABLE personalevent ALTER COLUMN enddate TYPE TIMESTAMP WITH TIME ZONE;
ALTER TABLE personalevent ALTER COLUMN startdate TYPE TIMESTAMP WITH TIME ZONE;

-- MYSQL
ALTER TABLE userdatabase CHANGE startdate startdate TIMESTAMP;
ALTER TABLE project CHANGE end_date end_date TIMESTAMP;
ALTER TABLE project CHANGE close_date close_date TIMESTAMP;

-- Increases the indicator name length (issue #408).
-- ------
ALTER TABLE indicator ALTER COLUMN name TYPE varchar(1024);


-- Increases the indicator category length (issue #434).
-- ------
ALTER TABLE indicator ALTER COLUMN category TYPE varchar(1024);


-- Merges 'risks' and 'hypothesis' columns of the log frame (issue #189).
-- ------

-- POSTGRESQL
ALTER TABLE log_frame_element ADD COLUMN risksAndAssumptions TEXT;

-- MYSQL
ALTER TABLE log_frame_element ADD risksAndAssumptions TEXT;


-- MYSQL AND POSTGRESQL
UPDATE log_frame_element SET risksAndAssumptions=( risks  || '\n' || assumptions) WHERE char_length(assumptions)>0 and char_length(risks)>0;
UPDATE log_frame_element SET risksAndAssumptions=risks WHERE (char_length(assumptions)=0 or assumptions is null)  and char_length(risks)>0;  
UPDATE log_frame_element SET risksAndAssumptions=assumptions WHERE (char_length(risks)=0 or risks is null)  and char_length(assumptions)>0;   
ALTER TABLE log_frame_element DROP risks;
ALTER TABLE log_frame_element DROP assumptions;

-- Add a date_deleted column to the table project_model and org_unit_model (issue #489)
-- ------

-- POSTGRESQL
ALTER TABLE org_unit_model ADD COLUMN date_deleted DATE;
ALTER TABLE project_model ADD COLUMN date_deleted DATE;

-- MYSQL
ALTER TABLE org_unit_model ADD COLUMN date_deleted DATETIME;
ALTER TABLE project_model ADD COLUMN date_deleted DATETIME;

-- Increases the project code length (issue #504).
-- ------

-- POSTGRESQL
ALTER TABLE userdatabase ALTER COLUMN name TYPE varchar(50);

-- MYSQL
ALTER TABLE userdatabase CHANGE name name varchar(50);

```


## 2. Existing data updates ##

```

-- Updates the countries ISO codes (issue #457)
UPDATE Country SET ISO2 = 'BN' WHERE CountryId = 281;
UPDATE Country SET ISO2 = 'CN' WHERE CountryId = 293;
UPDATE Country SET ISO2 = 'GN' WHERE CountryId = 339;
UPDATE Country SET ISO2 = 'HN' WHERE CountryId = 345;
UPDATE Country SET ISO2 = 'IN' WHERE CountryId = 349;
UPDATE Country SET ISO2 = 'MN' WHERE CountryId = 394;
UPDATE Country SET ISO2 = 'AN' WHERE CountryId = 404;
UPDATE Country SET ISO2 = 'PN' WHERE CountryId = 423;
UPDATE Country SET ISO2 = 'KN' WHERE CountryId = 434;
UPDATE Country SET ISO2 = 'SN' WHERE CountryId = 443;
UPDATE Country SET ISO2 = 'TN' WHERE CountryId = 472;
UPDATE Country SET ISO2 = 'VN' WHERE CountryId = 487;


-- Fixes issue with old inconsistent data in the log_frame_model table (issue #189)
UPDATE log_frame_model SET a_gp_max=1, a_max=1, a_per_er_max=1, a_per_gp_max=1, a_enable_groups=false, er_enable_groups=false, p_enable_groups=false, so_enable_groups=false, er_gp_max=1, er_max=1, er_per_gp_max=1, er_per_so_max=1, p_gp_max=1, p_max=1, p_per_gp_max=1, so_gp_max=1, so_max=1, so_per_gp_max=1 
WHERE name LIKE 'Auto-created default model at%';

-- Removes temporarily ACTIVITY INFO permission (issue #591)
DELETE FROM global_permission WHERE permission = 'VIEW_ACTIVITYINFO';

-- Deletes the projects links linked to a deleted project (issue #565)
DELETE FROM project_funding AS pf
	USING userdatabase AS ud
	WHERE ud.databaseid = pf.id_project_funded 
		AND ud.datedeleted is not null;
		
DELETE FROM project_funding AS pf
	USING userdatabase AS ud
	WHERE ud.databaseid = pf.id_project_funding
		AND ud.datedeleted is not null;
```

# Release 1.1 #

## 1. Schema changes ##

```

ALTER TABLE project DROP COLUMN starred ;  

CREATE TABLE project_userlogin
(
  project_databaseid integer NOT NULL,
  favoriteusers_userid integer NOT NULL,
  CONSTRAINT project_userlogin_pkey PRIMARY KEY (project_databaseid,    favoriteusers_userid),
  CONSTRAINT fk8076a4d884058733 FOREIGN KEY (project_databaseid)
      REFERENCES project (databaseid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk8076a4d8efbea106 FOREIGN KEY (favoriteusers_userid)
      REFERENCES userlogin (userid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE indicator ADD COLUMN directdataentryenabled boolean;
ALTER TABLE indicator ALTER COLUMN directdataentryenabled SET NOT NULL;
ALTER TABLE indicator ALTER COLUMN directdataentryenabled SET DEFAULT true;

```

## 2. Existing data updates ##

**After the schema is updated**, in order to update the existing data, the following request has to be applied (request required because of the issue [000352: OrgUnit administration lacking orgunit model status management](http://www.sigmah.org/issues/view.php?id=352) which lets user create orgunit from deletable draft orgunit models)

```
UPDATE org_unit_model
SET status = 'USED'
WHERE status='DRAFT' and org_unit_model_id in (select id_org_unit_model from partner where 1);
```


# Release 1.0-rc2 #

## 1. Schema changes ##

```

ALTER TABLE userdatabase ALTER COLUMN FullName TYPE VARCHAR(500);

ALTER TABLE org_unit_model DROP COLUMN min_level;

ALTER TABLE org_unit_model DROP COLUMN max_level;

```

# Release 1.0 #

## 1. Schema changes ##

```

ALTER TABLE partner ADD COLUMN deleted timestamp without time zone;

```

_For MySQL databases, use instead:_
ALTER TABLE partner ADD COLUMN deleted DATETIME DEFAULT NULL;

```
CREATE TABLE  indicator_datasource (
  IndicatorId int(11) NOT NULL,
  IndicatorSourceId int(11) NOT NULL,
  PRIMARY KEY (IndicatorId,IndicatorSourceId),
  KEY `FK7A87F87547C62157` (IndicatorId),
  KEY `FK7A87F8755038B772` (IndicatorSourceId)
);

```

Note: all existing logframe elements will be lost. I'm not aware of any real logframes in the wild yet, but if there are they will have to be migrated by hand to redo the ids.

```

DROP TABLE log_frame_expected_result;
DROP TABLE log_frame_specific_objective;
DROP TABLE log_frame_activity;

CREATE TABLE  log_frame_element (
  id_element int(11) NOT NULL AUTO_INCREMENT,
  assumptions text,
  code int(11) NOT NULL,
  position int(11) DEFAULT NULL,
  risks text,
  id_group int(11) DEFAULT NULL,
  PRIMARY KEY (`id_element`),
  KEY `FK5A2E206F4F6005EE` (id_group)
);

CREATE TABLE  log_frame_specific_objective (
  `intervention_logic` text,
  `id_element` int(11) NOT NULL,
  `id_log_frame` int(11) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `FKC979EF199BC5C4DA` (`id_log_frame`),
  KEY `FKC979EF19E41DAE8` (`id_element`)
);

CREATE TABLE  log_frame_expected_result (
  `intervention_logic` text,
  `id_element` int(11) NOT NULL,
  `id_specific_objective` int(11) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `FK99D3DDF7D88379D4` (`id_specific_objective`),
  KEY `FK99D3DDF7E41DAE8` (`id_element`)
);

CREATE TABLE log_frame_activity (
  advancement int(11) DEFAULT NULL,
  endDate datetime DEFAULT NULL,
  startDate datetime DEFAULT NULL,
  title text,
  id_element int(11) NOT NULL,
  id_result int(11) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `FK89611FFC8012BC39` (`id_result`),
  KEY `FK89611FFCE41DAE8` (`id_element`)
);

CREATE TABLE  log_frame_indicators (
  `log_frame_element_id_element` int(11) NOT NULL,
  `indicators_IndicatorId` int(11) NOT NULL,
  PRIMARY KEY (`log_frame_element_id_element`,`indicators_IndicatorId`),
  KEY `FK17E5A9F1F6E4C4B8` (`log_frame_element_id_element`),
  KEY `FK17E5A9F1A023DDC` (`indicators_IndicatorId`)
);

```

# Release 0.9.1 #

## 1. Schema changes ##

From 0.9 to 0.9.1, the following changes have to be performed on the schema:

```

ALTER TABLE log_frame DROP COLUMN title;

ALTER TABLE project ADD COLUMN activity_advancement INTEGER ;

ALTER TABLE log_frame_activity ADD COLUMN advancement INTEGER ;

ALTER TABLE projectreport ADD COLUMN orgunit_partnerid INTEGER ;

ALTER TABLE category_type ADD COLUMN id_organization INTEGER ;

ALTER TABLE category_element ADD COLUMN id_organization INTEGER ;

ALTER TABLE quality_framework ADD COLUMN id_organization INTEGER ;

ALTER TABLE quality_criterion ADD COLUMN id_organization INTEGER ;

ALTER TABLE privacy_group ADD COLUMN id_organization INTEGER ;

ALTER TABLE profile ADD COLUMN id_organization INTEGER ;

ALTER TABLE projectreportmodel ADD COLUMN id_organization INTEGER ;

ALTER TABLE org_unit_model ADD COLUMN id_organization INTEGER ;

ALTER TABLE monitored_point ADD COLUMN deleted BIT(1);

ALTER TABLE reminder ADD COLUMN deleted BIT(1);

```

## 2. Existing data updates ##

**After the schema is updated**, in order to update the existing data, the following requests have to be applied: (requests only valid for database with a single organization)


```

UPDATE category_type SET id_organization = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL) ;

UPDATE category_element SET id_organization = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE quality_framework SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE quality_criterion SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE privacy_group SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE profile SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE projectreportmodel SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

UPDATE org_unit_model SET id_organization  = (SELECT MAX(id_organization) FROM organization WHERE id_root_org_unit IS NOT NULL);

```

# Release 0.9 #

From 0.8.1 to 0.9, the following changes have to be performed on the schema:


```
DROP TABLE report;

ALTER TABLE project_model ADD COLUMN status VARCHAR(20) DEFAULT 'READY';
UPDATE project_model SET status = 'READY' WHERE status IS NULL;

ALTER TABLE org_unit_model ADD COLUMN status VARCHAR(20) DEFAULT 'READY';
UPDATE org_unit_model SET status = 'READY' WHERE status IS NULL;

ALTER TABLE Indicator CHANGE ActivityId ActivityId int(11) NULL;
ALTER TABLE Indicator CHANGE Units Units varchar(15) NULL;

ALTER TABLE locationtype CHANGE LocationTypeId LocationTypeId int(11) NOT NULL AUTO_INCREMENT; 

ALTER TABLE Site CHANGE ActivityId ActivityId int(11) NULL;
```



# Release 0.70 #

A large number of domain objects have been added since the last full release of ActivityInfo (0.5.11). Users are advised to let hibernate create a new schema and import your existing data into the new structure with a mapping tool.

[OpenDbCopy](http://opendbcopy.sourceforge.net/) is a good tool that we have used for ActivityInfo.org.

**WARNING**: Do NOT attempt to use hibernate's schema update feature on production data! This is a [good posting](http://stackoverflow.com/questions/221379/hibernate-hbm2ddl-autoupdate-in-production) on why this is not OK.

In addition, to use the new offline features, you will need to update your data to meet certain assumptions made by the synchronization module.

Specifically, the synchronizer uses timestamps to divide updates into batches. Since early versions of AI did not maintain timestamps, your database may have a large number of records with the same timestamp. Future versions of AI/Sigmah may be capable of more sophisticated batching but for the time being you can "salt" your data with the following SQL:

```
UPDATE Location SET dateEdited = date_add(dateEdited, INTERVAL LocationId SECOND) where second(dateEdited) = 0;

UPDATE Site SET dateEdited = date_add(dateEdited, INTERVAL LocationId SECOND) where second(dateEdited) = 0;
```



# Revision [r138](https://code.google.com/p/sigma-h/source/detail?r=138) #

  * The columns !changePasswordKey and !dateChangePasswordKeyIssued have been added to the UserLogin table

```
alter table UserLogin add changePasswordKey nvarchar(64)
alter table UserLogin add dateChangePasswordKeyIssued date
```


# November 30, 2009 / Release 0.5.6 #

  * The columns ManageUsers, ManageAllUsers have been added to the UserPermissions table.
```
ALTER TABLE UserPermission ADD
  AllowManageUsers bit NOT NULL 
     CONSTRAINT DF_UserPermission_AllowManageUsers DEFAULT 0,
  AllowManageAllUsers bit NOT NULL 
     CONSTRAINT DF_UserPermission_AllowManageAllusers DEFAULT 0
```


# Revision [r1215](https://code.google.com/p/sigma-h/source/detail?r=1215) #
  * Global export(export logger), Global export content (CSV content of export) and Global export settings (export settings per organization)
```
CREATE TABLE global_export
(
  id bigint NOT NULL,
  generated_date timestamp without time zone,
  organization_id integer NOT NULL,
  CONSTRAINT global_export_pkey PRIMARY KEY (id ),
  CONSTRAINT fk9e763fd0f85c2c3c FOREIGN KEY (organization_id)
      REFERENCES organization (id_organization) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE global_export_content
(
  id bigint NOT NULL,
  csv_content text,
  project_model_name character varying(8192) NOT NULL,
  global_export_id bigint NOT NULL,
  CONSTRAINT global_export_content_pkey PRIMARY KEY (id ),
  CONSTRAINT fkdca84b0af33647b9 FOREIGN KEY (global_export_id)
      REFERENCES global_export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE global_export_settings
(
  id bigint NOT NULL,
  auto_delete_frequency integer,
  auto_export_frequency integer,
  default_organization_export_format character varying(255),
  export_format character varying(255),
  last_export_date timestamp without time zone,
  locale_string character varying(4) NOT NULL,
  organization_id integer NOT NULL,
  CONSTRAINT global_export_settings_pkey PRIMARY KEY (id ),
  CONSTRAINT fk2fb477b2f85c2c3c FOREIGN KEY (organization_id)
      REFERENCES organization (id_organization) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

```
  * Default global export settings

```
INSERT INTO global_export_settings (id, default_organization_export_format, auto_export_frequency, locale_string, organization_id) 
SELECT nextval('hibernate_sequence'),'ODS',1,'fr', o.id_organization from organization o limit 1;
```

> two added export related flags
```
update flexible_element set exportable =true;
update flexible_element set globally_exportable =false;
```

  * Adds default GLOBAL\_EXPORT permission to default "PioneerAdministrator" profile

```
INSERT INTO global_permission (id_global_permission, permission, id_profile) SELECT nextval('hibernate_sequence'), 'GLOBAL_EXPORT', id_profile FROM profile WHERE name = 'PioneerAdministrator' AND id_organization = (SELECT MAX(id_organization) FROM organization WHERE logo = 'logo');
```