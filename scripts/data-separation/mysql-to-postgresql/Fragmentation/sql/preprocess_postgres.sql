ALTER TABLE history_token ALTER COLUMN value DROP NOT NULL;
ALTER TABLE org_unit_model ALTER COLUMN title DROP NOT NULL;
ALTER TABLE question_choice_element ALTER COLUMN label DROP NOT NULL;

DROP SEQUENCE IF EXISTS sort_order_sequence CASCADE;
CREATE SEQUENCE sort_order_sequence INCREMENT BY 10 MINVALUE 0 NO MAXVALUE START WITH 0;