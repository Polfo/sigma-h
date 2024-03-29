package org.sigmah.shared.dto.element;

import java.util.Date;
import java.util.List;

import org.sigmah.client.i18n.I18N;
import org.sigmah.client.util.DateUtils;
import org.sigmah.client.util.HistoryTokenText;
import org.sigmah.shared.command.GetCountries;
import org.sigmah.shared.command.GetCountry;
import org.sigmah.shared.command.GetSitesCount;
import org.sigmah.shared.command.GetUsersByOrganization;
import org.sigmah.shared.command.result.CountryResult;
import org.sigmah.shared.command.result.SiteResult;
import org.sigmah.shared.command.result.UserListResult;
import org.sigmah.shared.command.result.ValueResult;
import org.sigmah.shared.dao.Filter;
import org.sigmah.shared.domain.element.DefaultFlexibleElementType;
import org.sigmah.shared.dto.CountryDTO;
import org.sigmah.shared.dto.OrgUnitDTO;
import org.sigmah.shared.dto.OrgUnitDTOLight;
import org.sigmah.shared.dto.ProjectDTO;
import org.sigmah.shared.dto.UserDTO;
import org.sigmah.shared.dto.element.handler.RequiredValueEvent;
import org.sigmah.shared.dto.element.handler.ValueEvent;
import org.sigmah.shared.dto.history.HistoryTokenListDTO;
import org.sigmah.shared.report.model.DimensionType;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * DTO mapping class for entity element.DefaultFlexibleElement.
 * 
 * @author tmi
 */
public class DefaultFlexibleElementDTO extends FlexibleElementDTO {

	private static final long serialVersionUID = 3746586633233053639L;

	private transient ListStore<CountryDTO> countriesStore;

	private transient ListStore<UserDTO> usersStore;

	private transient ListStore<OrgUnitDTOLight> orgUnitsStore;

	protected transient DefaultFlexibleElementContainer container;

	@Override
	public String getEntityName() {
		return "element.DefaultFlexibleElement";
	}

	// Type.
	public DefaultFlexibleElementType getType() {
		return get("type");
	}

	public void setType(DefaultFlexibleElementType type) {
		set("type", type);
	}

	public ListStore<CountryDTO> getCountriesStore() {
		return countriesStore;
	}

	public ListStore<UserDTO> getManagersStore() {
		return usersStore;
	}
	
	@Override
	public String getFormattedLabel() {
		return getLabel() != null ? getLabel() : getTypeLabel();
	}

	public String getTypeLabel() {
		return DefaultFlexibleElementType.getName(getType());
	}
	
	@Override
	protected Component getComponent(ValueResult valueResult, boolean enabled) {
		if (valueResult != null && valueResult.isValueDefined())
			return getComponentWithValue(valueResult, enabled);
		else
			return getComponent(enabled);
	}

	@Override
	protected Component getComponentInBanner(ValueResult valueResult, boolean enabled) {

		if (currentContainerDTO instanceof DefaultFlexibleElementContainer) {
			container = (DefaultFlexibleElementContainer) currentContainerDTO;
		} else {
			throw new IllegalArgumentException(
							"The flexible elements container isn't an instance of DefaultFlexibleElementContainer. The default flexible element connot be instanciated.");
		}
		//Budget case handled by the budget element itself
		return super.getComponentInBanner(valueResult, enabled);

	}

	protected Component getComponent(boolean enabled) {

		if (currentContainerDTO instanceof DefaultFlexibleElementContainer) {
			container = (DefaultFlexibleElementContainer) currentContainerDTO;
		} else {
			throw new IllegalArgumentException(
							"The flexible elements container isn't an instance of DefaultFlexibleElementContainer. The default flexible element connot be instanciated.");
		}

		final DateTimeFormat DATE_FORMAT = DateUtils.DATE_SHORT;
		final Component component;

		switch (getType()) {
		// Project code.
		case CODE: {

			final Field<?> field;

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<String> textField = createStringField(50, false);
				textField.setValue(container.getName());
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				labelField.setValue(container.getName());
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		// Project title.
		case TITLE: {

			final Field<?> field;

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<String> textField = createStringField(500, false);
				textField.setValue(container.getFullName());
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				labelField.setValue(container.getFullName());
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;

		case START_DATE: {

			final Field<?> field;
			final Date sd = container.getStartDate();

			// Builds the field and sets its value.
			if (enabled) {
				final DateField dateField = createDateField(false);
				dateField.setValue(sd);
				field = dateField;

			} else {

				final LabelField labelField = createLabelField();
				if (sd != null) {
					labelField.setValue(DATE_FORMAT.format(sd));
				}
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case END_DATE: {

			final Field<?> field;
			final Date ed = container.getEndDate();

			// Builds the field and sets its value.
			if (enabled) {
				final DateField dateField = createDateField(true);
				dateField.setValue(ed);
				field = dateField;

			} else {

				final LabelField labelField = createLabelField();
				if (ed != null) {
					labelField.setValue(DATE_FORMAT.format(ed));
				}
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case COUNTRY: {

			// COUNTRY of project should not be changeable except OrgUnit's
			enabled &= !(container instanceof ProjectDTO);

			final Field<?> field;
			final CountryDTO c = container.getCountry();

			if (enabled) {
				final ComboBox<CountryDTO> comboBox = new ComboBox<CountryDTO>();
				comboBox.setEmptyText(I18N.CONSTANTS.flexibleElementDefaultSelectCountry());

				if (countriesStore == null) {
					countriesStore = new ListStore<CountryDTO>();
				}

				comboBox.setStore(countriesStore);
				comboBox.setDisplayField("name");
				comboBox.setValueField("id");
				comboBox.setTriggerAction(TriggerAction.ALL);
				comboBox.setEditable(true);
				comboBox.setAllowBlank(true);

				// if country store is empty
				if (countriesStore.getCount() == 0) {

					if (cache != null) {
						cache.getCountryCache().get(new AsyncCallback<List<CountryDTO>>() {

							@Override
							public void onFailure(Throwable e) {
								Log.error("[getComponent] Error while getting countries list.", e);
							}

							@Override
							public void onSuccess(List<CountryDTO> result) {
								// Fills the store.
								countriesStore.add(result);
							}
						});
					} else /* cache is null */{
						dispatcher.execute(new GetCountries(), null, new AsyncCallback<CountryResult>() {

							@Override
							public void onFailure(Throwable e) {
								Log.error("[getComponent] Error while getting countries list.", e);
							}

							@Override
							public void onSuccess(CountryResult result) {

								// Fills the store.
								countriesStore.add(result.getData());
							}
						});
					}

				}

				// Listens to the selection changes.
				comboBox.addSelectionChangedListener(new SelectionChangedListener<CountryDTO>() {

					@Override
					public void selectionChanged(SelectionChangedEvent<CountryDTO> se) {

						String value = null;
						final boolean isValueOn;

						// Gets the selected choice.
						final CountryDTO choice = se.getSelectedItem();

						// Checks if the choice isn't the default empty
						// choice.
						isValueOn = choice != null && choice.getId() != -1;

						if (choice != null) {
							value = String.valueOf(choice.getId());
						}

						if (value != null) {
							// Fires value change event.
							handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this, value));
						}

						// Required element ?
						if (getValidates()) {
							handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
						}
					}
				});

				if (c != null) {
					comboBox.setValue(c);
				}

				field = comboBox;
			} else /* not enabled */{

				final LabelField labelField = createLabelField();

				if (c == null) {
					labelField.setValue("-");
				} else {
					labelField.setValue(c.getName());
				}

				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case OWNER: {

			final LabelField labelField = createLabelField();

			// Sets the field label.
			labelField.setFieldLabel(getFormattedLabel());

			// Sets the value to the field.
			labelField.setValue(container.getOwnerFirstName() != null ? container.getOwnerFirstName() + " "
							+ container.getOwnerName() : container.getOwnerName());

			component = labelField;
		}
			break;
		case MANAGER: {

			final Field<?> field;
			final UserDTO u = container.getManager();

			if (enabled) {

				final ComboBox<UserDTO> comboBox = new ComboBox<UserDTO>();
				comboBox.setEmptyText(I18N.CONSTANTS.flexibleElementDefaultSelectManager());

				if (usersStore == null) {
					usersStore = new ListStore<UserDTO>();
				}

				comboBox.setStore(usersStore);
				comboBox.setDisplayField("cname");
				comboBox.setValueField("id");
				comboBox.setTriggerAction(TriggerAction.ALL);
				comboBox.setEditable(true);
				comboBox.setAllowBlank(true);

				// Retrieves the county list.
				if (usersStore.getCount() == 0) {

					if (cache != null) {

						cache.getUserCache().get(new AsyncCallback<List<UserDTO>>() {

							@Override
							public void onFailure(Throwable e) {
								Log.error("[getComponent] Error while getting users list.", e);
							}

							@Override
							public void onSuccess(List<UserDTO> result) {

								// Fills the store.
								usersStore.add(result);

								// Sets the value to the field.
								if (u != null) {
									for (final UserDTO model : usersStore.getModels()) {
										if (model.getId() == u.getId()) {
											comboBox.setValue(model);
										}
									}
								}

								// Listens to the selection changes.
								comboBox.addSelectionChangedListener(new SelectionChangedListener<UserDTO>() {

									@Override
									public void selectionChanged(SelectionChangedEvent<UserDTO> se) {

										String value = null;
										final boolean isValueOn;

										// Gets the selected choice.
										final UserDTO choice = se.getSelectedItem();

										// Checks if the choice isn't the
										// default empty choice.
										isValueOn = choice != null && choice.getId() != -1;

										if (choice != null) {
											value = String.valueOf(choice.getId());
										}

										if (value != null) {
											// Fires value change event.
											handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this,
															value));
										}

										// Required element ?
										if (getValidates()) {
											handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
										}
									}
								});
							}
						});
					} else {

						dispatcher.execute(new GetUsersByOrganization(authentication.getOrganizationId()), null,
										new AsyncCallback<UserListResult>() {

											@Override
											public void onFailure(Throwable e) {
												Log.error("[getComponent] Error while getting users list.", e);
											}

											@Override
											public void onSuccess(UserListResult result) {

												// Fills the store.
												usersStore.add(result.getList());

												// Sets the value to the field.
												if (u != null) {
													comboBox.setValue(u);
												}

												// Listens to the selection
												// changes.
												comboBox.addSelectionChangedListener(new SelectionChangedListener<UserDTO>() {

													@Override
													public void selectionChanged(SelectionChangedEvent<UserDTO> se) {

														String value = null;
														final boolean isValueOn;

														// Gets the selected
														// choice.
														final UserDTO choice = se.getSelectedItem();

														// Checks if the choice
														// isn't
														// the
														// default empty choice.
														isValueOn = choice != null && choice.getId() != -1;

														if (choice != null) {
															value = String.valueOf(choice.getId());
														}

														if (value != null) {
															// Fires value
															// change event.
															handlerManager.fireEvent(new ValueEvent(
																			DefaultFlexibleElementDTO.this, value));
														}

														// Required element ?
														if (getValidates()) {
															handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
														}
													}
												});
											}
										});
					}
				} else {

					// Sets the value to the field.
					if (u != null) {
						comboBox.setValue(u);
					}

					// Listens to the selection changes.
					comboBox.addSelectionChangedListener(new SelectionChangedListener<UserDTO>() {

						@Override
						public void selectionChanged(SelectionChangedEvent<UserDTO> se) {

							String value = null;
							final boolean isValueOn;

							// Gets the selected choice.
							final UserDTO choice = se.getSelectedItem();

							// Checks if the choice isn't the default empty
							// choice.
							isValueOn = choice != null && choice.getId() != -1;

							if (choice != null) {
								value = String.valueOf(choice.getId());
							}

							if (value != null) {
								// Fires value change event.
								handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this, value));
							}

							// Required element ?
							if (getValidates()) {
								handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
							}
						}
					});
				}

				field = comboBox;

			} else {

				final LabelField labelField = createLabelField();

				if (u == null) {
					labelField.setValue("-");
				} else {
					labelField.setValue(u.getFirstName() != null ? u.getFirstName() + " " + u.getName() : u.getName());
				}

				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case ORG_UNIT: {

			final Field<?> field;
			final int id = container.getOrgUnitId();

			// Org unit field is always read-only for org unit.
			enabled &= !(container instanceof OrgUnitDTO);

			if (enabled) {

				final ComboBox<OrgUnitDTOLight> comboBox = new ComboBox<OrgUnitDTOLight>();

				if (orgUnitsStore == null) {
					orgUnitsStore = new ListStore<OrgUnitDTOLight>();
				}

				comboBox.setStore(orgUnitsStore);
				comboBox.setDisplayField("completeName");
				comboBox.setValueField("id");
				comboBox.setTriggerAction(TriggerAction.ALL);
				comboBox.setEditable(true);
				comboBox.setAllowBlank(true);

				if (orgUnitsStore.getCount() == 0) {

					cache.getOrganizationCache().get(new AsyncCallback<OrgUnitDTOLight>() {

						/**
						 * Fills recursively the combobox from the given root
						 * org unit.
						 * 
						 * @param root
						 *            The root org unit.
						 */
						private void recursiveFillOrgUnitsList(OrgUnitDTOLight root) {

							if (root.getCanContainProjects()) {
								if (root.getId() != id) {
									orgUnitsStore.add(root);
								}
							}

							for (final OrgUnitDTOLight child : root.getChildrenDTO()) {
								recursiveFillOrgUnitsList(child);
							}
						}

						@Override
						public void onFailure(Throwable e) {
							Log.error("[getComponent] Error while getting users info.", e);
						}

						@Override
						public void onSuccess(OrgUnitDTOLight result) {

							orgUnitsStore.add(cache.getOrganizationCache().get(id));

							// Fills the store.
							recursiveFillOrgUnitsList(result);

							// Sets the value to the field.
							if (id != -1) {
								for (final OrgUnitDTOLight model : orgUnitsStore.getModels()) {
									if (model.getId() == id) {
										comboBox.setValue(model);
									}
								}
							}

							// Listens to the selection changes.
							comboBox.addSelectionChangedListener(new SelectionChangedListener<OrgUnitDTOLight>() {

								@Override
								public void selectionChanged(final SelectionChangedEvent<OrgUnitDTOLight> se) {

									if (container instanceof ProjectDTO) {

										Log.debug("OrgUnit in project details.");

										final ProjectDTO currentProject = (ProjectDTO) container;

										Filter filter = new Filter();
										filter.addRestriction(DimensionType.Database, currentProject.getId());

										GetSitesCount getSitesCountCmd = new GetSitesCount(filter);

										dispatcher.execute(getSitesCountCmd, null, new AsyncCallback<SiteResult>() {

											@Override
											public void onFailure(Throwable caught) {

												Log.error("[getSitesCountCmd] Error while getting the count of sites.",
																caught);

											}

											@Override
											public void onSuccess(SiteResult result) {

												// Gets the selected choice.
												final OrgUnitDTOLight choice = se.getSelectedItem();

												// Current poject's country
												final CountryDTO projectCountry = currentProject.getCountry();

												// New OrgUnit's country
												final CountryDTO orgUnitCountry = choice.getOfficeLocationCountry();

												Log.debug("geting site result: " + result.getSiteCount());

												if (result != null && result.getSiteCount() > 0
																&& projectCountry != null && orgUnitCountry != null
																&& projectCountry != orgUnitCountry) {// If
																										// the
																										// new
																										// OrgUnit's
																										// country
																										// different
																										// from
																										// the
																										// current
																										// country
																										// of
																										// project
																										// inform
																										// users
																										// that
																										// it
																										// will
																										// continue
																										// use
																										// the
																										// country
																										// of
																										// project
																										// not
																										// new
																										// OrgUnit's

													Log.debug("[getSitesCountCmd]-Site count is: "
																	+ result.getSiteCount());

													MessageBox.confirm(I18N.CONSTANTS.changeOrgUnit(),
																	I18N.CONSTANTS.changeOrgUnitDetails(),
																	new Listener<MessageBoxEvent>() {

																		@Override
																		public void handleEvent(MessageBoxEvent be) {

																			if (Dialog.NO.equals(be.getButtonClicked()
																							.getItemId())) {
																				// Rollback
																				// the
																				// value

																				comboBox.setValue(orgUnitsStore
																								.findModel("id",
																												currentProject.getOrgUnitId()));

																				return;

																			} else {

																				Log.debug("You choose the Yes to change !");

																				String value = null;
																				final boolean isValueOn;

																				// Checks
																				// if
																				// the
																				// choice
																				// isn't
																				// the
																				// default
																				// empty
																				// choice.
																				isValueOn = choice != null
																								&& choice.getId() != -1;

																				if (choice != null) {
																					value = String.valueOf(choice
																									.getId());
																				}

																				if (value != null) {
																					// Fires
																					// value
																					// change
																					// event.
																					handlerManager.fireEvent(new ValueEvent(
																									DefaultFlexibleElementDTO.this,
																									value));
																				}

																				// Required
																				// element
																				// ?
																				if (getValidates()) {
																					handlerManager.fireEvent(new RequiredValueEvent(
																									isValueOn));
																				}

																			}

																		}
																	});

												} else {

													String value = null;
													final boolean isValueOn;

													// Checks if the choice
													// isn't the
													// default empty choice.
													isValueOn = choice != null && choice.getId() != -1;

													if (choice != null) {
														value = String.valueOf(choice.getId());
													}

													if (value != null) {
														// Fires value change
														// event.
														handlerManager.fireEvent(new ValueEvent(
																		DefaultFlexibleElementDTO.this, value, true));
													}

													// Required element ?
													if (getValidates()) {
														handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
													}

												}

											}

										});
									} else {// Non project container

										Log.debug("OrgUnit in non-project.");

										String value = null;
										final boolean isValueOn;

										// Gets the selected choice.
										final OrgUnitDTOLight choice = se.getSelectedItem();

										// Checks if the choice isn't the
										// default empty choice.
										isValueOn = choice != null && choice.getId() != -1;

										if (choice != null) {
											value = String.valueOf(choice.getId());
										}

										if (value != null) {
											// Fires value change event.
											handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this,
															value));
										}

										// Required element ?
										if (getValidates()) {
											handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
										}

									}

								}
							});
						}
					});

				} else {

					// Sets the value to the field.
					if (id != -1) {
						for (final OrgUnitDTOLight model : orgUnitsStore.getModels()) {
							if (model.getId() == id) {
								comboBox.setValue(model);
							}
						}
					}

					// Listens to the selection changes.
					comboBox.addSelectionChangedListener(new SelectionChangedListener<OrgUnitDTOLight>() {

						@Override
						public void selectionChanged(final SelectionChangedEvent<OrgUnitDTOLight> se) {

							if (container instanceof ProjectDTO) {

								final ProjectDTO currentProject = (ProjectDTO) container;

								Filter filter = new Filter();
								filter.addRestriction(DimensionType.Database, currentProject.getId());

								GetSitesCount getSitesCountCmd = new GetSitesCount(filter);

								dispatcher.execute(getSitesCountCmd, null, new AsyncCallback<SiteResult>() {

									@Override
									public void onFailure(Throwable caught) {

										Log.error("[getSitesCountCmd] Error while getting the count of sites.", caught);

									}

									@Override
									public void onSuccess(SiteResult result) {

										// Gets the selected choice.
										final OrgUnitDTOLight choice = se.getSelectedItem();

										// Current poject's country
										final CountryDTO projectCountry = currentProject.getCountry();

										// New OrgUnit's country
										final CountryDTO orgUnitCountry = choice.getOfficeLocationCountry();

										if (result != null && result.getSiteCount() > 0 && projectCountry != null
														&& orgUnitCountry != null && projectCountry != orgUnitCountry) {

											MessageBox.confirm(I18N.CONSTANTS.changeOrgUnit(),
															I18N.CONSTANTS.changeOrgUnitDetails(),
															new Listener<MessageBoxEvent>() {

																@Override
																public void handleEvent(MessageBoxEvent be) {

																	if (Dialog.NO.equals(be.getButtonClicked()
																					.getItemId())) {
																		// Rollback
																		// the
																		// value
																		comboBox.setValue(orgUnitsStore.findModel("id",
																						currentProject.getOrgUnitId()));
																		return;

																	} else {
																		String value = null;
																		final boolean isValueOn;

																		// Checks
																		// if
																		// the
																		// choice
																		// isn't
																		// the
																		// default
																		// empty
																		// choice.
																		isValueOn = choice != null
																						&& choice.getId() != -1;

																		if (choice != null) {
																			value = String.valueOf(choice.getId());
																		}

																		if (value != null) {
																			// Fires
																			// value
																			// change
																			// event.
																			handlerManager.fireEvent(new ValueEvent(
																							DefaultFlexibleElementDTO.this,
																							value));
																		}

																		// Required
																		// element
																		// ?
																		if (getValidates()) {
																			handlerManager.fireEvent(new RequiredValueEvent(
																							isValueOn));
																		}

																	}

																}
															});

										} else {

											String value = null;
											final boolean isValueOn;

											// Checks if the choice isn't the
											// default empty choice.
											isValueOn = choice != null && choice.getId() != -1;

											if (choice != null) {
												value = String.valueOf(choice.getId());
											}

											if (value != null) {
												// Fires value change event.
												handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this,
																value, true));
											}

											// Required element ?
											if (getValidates()) {
												handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
											}

										}

									}

								});
							} else {// Non project container

								Log.debug("OrgUnit in non-project 2.");

								String value = null;
								final boolean isValueOn;

								// Gets the selected choice.
								final OrgUnitDTOLight choice = se.getSelectedItem();

								// Checks if the choice isn't the
								// default empty choice.
								isValueOn = choice != null && choice.getId() != -1;

								if (choice != null) {
									value = String.valueOf(choice.getId());
								}

								if (value != null) {
									// Fires value change event.
									handlerManager.fireEvent(new ValueEvent(DefaultFlexibleElementDTO.this, value));
								}

								// Required element ?
								if (getValidates()) {
									handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
								}

							}

						}
					});
				}

				field = comboBox;
			} else {

				final LabelField labelField = createLabelField();

				cache.getOrganizationCache().get(id, new AsyncCallback<OrgUnitDTOLight>() {

					@Override
					public void onFailure(Throwable e) {
						Log.error("[getComponent] Error while getting users info.", e);
					}

					@Override
					public void onSuccess(OrgUnitDTOLight result) {
						if (result == null) {
							labelField.setValue("-");
						} else {
							labelField.setValue(result.getName() + " - " + result.getFullName());
						}
					}
				});

				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		default:
			throw new IllegalArgumentException("[getComponent] The type '" + getType()
							+ "' for the default flexible element doen't exist.");
		}

		return component;
	}

	protected Component getComponentWithValue(ValueResult valueResult, boolean enabled) {

		final DateTimeFormat DATE_FORMAT = DateUtils.DATE_SHORT;
		final Component component;

		switch (getType()) {
		// Project code.
		case CODE: {

			final Field<?> field;

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<String> textField = createStringField(16, false);
				textField.setValue(valueResult.getValueObject());
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				labelField.setValue(valueResult.getValueObject());
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		// Project title.
		case TITLE: {

			final Field<?> field;

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<String> textField = createStringField(500, false);
				textField.setValue(valueResult.getValueObject());
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				labelField.setValue(valueResult.getValueObject());
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;

		case START_DATE: {

			final Field<?> field;
			final Date sd = new Date(Long.parseLong(valueResult.getValueObject()));

			// Builds the field and sets its value.
			if (enabled) {
				final DateField dateField = createDateField(false);
				dateField.setValue(sd);
				field = dateField;

			} else {

				final LabelField labelField = createLabelField();
				if (sd != null) {
					labelField.setValue(DATE_FORMAT.format(sd));
				}
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case END_DATE: {

			final Field<?> field;
			final Date ed = new Date(Long.parseLong(valueResult.getValueObject()));

			// Builds the field and sets its value.
			if (enabled) {
				final DateField dateField = createDateField(true);
				dateField.setValue(ed);
				field = dateField;

			} else {

				final LabelField labelField = createLabelField();
				if (ed != null) {
					labelField.setValue(DATE_FORMAT.format(ed));
				}
				field = labelField;
			}

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		
		case COUNTRY: {

			// COUNTRY of project should not be changeable

			final Field<Object> field;
			final int countryId = Integer.parseInt(valueResult.getValueObject());

			// Builds the field and sets its value.
			final LabelField labelField = createLabelField();
			field = labelField;

			dispatcher.execute(new GetCountry(countryId), null, new AsyncCallback<CountryDTO>() {

				@Override
				public void onFailure(Throwable caught) {
					field.setValue("-");
				}

				@Override
				public void onSuccess(CountryDTO result) {
					field.setValue(result.getName());
				}

			});

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;

		}
			break;
		case OWNER: {

			final LabelField labelField = createLabelField();

			// Sets the field label.
			labelField.setFieldLabel(getFormattedLabel());

			// Sets the value to the field.
			labelField.setValue(valueResult.getValueObject());

			component = labelField;
		}
			break;
		case MANAGER: {

			final Field<Object> field;
			final int userId = Integer.parseInt(valueResult.getValueObject());

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<Object> textField = new TextField<Object>();
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				field = labelField;
			}

			dispatcher.execute(new GetUsersByOrganization(authentication.getOrganizationId(), userId), null,
							new AsyncCallback<UserListResult>() {

								@Override
								public void onFailure(Throwable caught) {
									field.setValue("-");
								}

								@Override
								public void onSuccess(UserListResult result) {
									field.setValue(result.getList().get(0).getCompleteName());
								}

							});

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		case ORG_UNIT: {

			final Field<Object> field;
			final int orgUnitId = Integer.parseInt(valueResult.getValueObject());

			// Builds the field and sets its value.
			if (enabled) {
				final TextField<Object> textField = new TextField<Object>();
				field = textField;

			} else {
				final LabelField labelField = createLabelField();
				field = labelField;
			}

			cache.getOrganizationCache().get(orgUnitId, new AsyncCallback<OrgUnitDTOLight>() {

				@Override
				public void onSuccess(OrgUnitDTOLight result) {
					field.setValue(result.getName() + " - " + result.getFullName());
				}

				@Override
				public void onFailure(Throwable caught) {
					field.setValue("-");
				}
			});

			// Sets the field label.
			field.setFieldLabel(getFormattedLabel());

			component = field;
		}
			break;
		default:
			throw new IllegalArgumentException("[getComponent] The type '" + getType()
							+ "' for the default flexible element doen't exist.");
		}

		return component;
	}

	@Override
	public boolean isCorrectRequiredValue(ValueResult result) {
		// These elements don't have any value.
		return true;
	}

	/**
	 * Method in charge of firing value events.
	 * 
	 * @param value
	 *            The raw value which is serialized to the server and saved to
	 *            the data layer.
	 * @param isValueOn
	 *            If the value is correct.
	 */
	protected void fireEvents(String value, boolean isValueOn) {

		Log.debug("raw Value is : " + value + "  isValueOn is :" + isValueOn);

		handlerManager.fireEvent(new ValueEvent(this, value));

		// Required element ?
		if (getValidates()) {
			handlerManager.fireEvent(new RequiredValueEvent(isValueOn));
		}
	}

	/**
	 * Create a text field to represent a default flexible element.
	 * 
	 * @param length
	 *            The max length of the field.
	 * @param allowBlank
	 *            If the field allow blank value.
	 * @return The text field.
	 */
	private TextField<String> createStringField(final int length, final boolean allowBlank) {

		final TextField<String> textField = new TextField<String>();
		textField.setAllowBlank(allowBlank);

		// Sets the max length.
		textField.setMaxLength(length);

		// Adds the listeners.
		textField.addListener(Events.OnKeyUp, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {

				String rawValue = textField.getValue();

				if (rawValue == null) {
					rawValue = "";
				}

				// The value is valid if it contains at least one non-blank
				// character.
				final boolean isValueOn = !rawValue.trim().equals("") && !(rawValue.length() > length);

				if (!(!allowBlank && !isValueOn)) {
					fireEvents(rawValue, isValueOn);
				}
			}
		});

		return textField;
	}

	/**
	 * Create a date field to represent a default flexible element.
	 * 
	 * @param allowBlank
	 *            If the field allow blank value.
	 * @return The date field.
	 */
	private DateField createDateField(final boolean allowBlank) {

		final DateTimeFormat DATE_FORMAT = DateUtils.DATE_SHORT;

		// Creates a date field which manages date picker selections and
		// manual selections.
		final DateField dateField = new DateField();
		dateField.getPropertyEditor().setFormat(DATE_FORMAT);
		dateField.setEditable(allowBlank);
		dateField.setAllowBlank(allowBlank);
		preferredWidth = 120;

		// Adds the listeners.

		dateField.getDatePicker().addListener(Events.Select, new Listener<DatePickerEvent>() {

			@Override
			public void handleEvent(DatePickerEvent be) {

				// The date is saved as a timestamp.
				final String rawValue = String.valueOf(be.getDate().getTime());
				// The date picker always returns a valid date.
				final boolean isValueOn = true;

				fireEvents(rawValue, isValueOn);
			}
		});

		dateField.addListener(Events.OnKeyUp, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {

				final Date date = dateField.getValue();

				// The date is invalid, fires only a required event to
				// invalidate some previously valid date.
				if (date == null) {

					// Required element ?
					if (getValidates()) {
						handlerManager.fireEvent(new RequiredValueEvent(false));
					}

					if (allowBlank) {
						fireEvents("", false);
					}

					return;
				}

				// The date is saved as a timestamp.
				final String rawValue = String.valueOf(date.getTime());
				// The date is valid here.
				final boolean isValueOn = true;

				if (!(!allowBlank && !isValueOn)) {
					fireEvents(rawValue, isValueOn);
				}
			}
		});

		return dateField;
	}

	/**
	 * Create a number field to represent a default flexible element.
	 * 
	 * @param allowBlank
	 *            If the field allow blank value.
	 * @return The number field.
	 */
	protected NumberField createNumberField(final boolean allowBlank) {

		final NumberField numberField = new NumberField();
		numberField.setAllowDecimals(true);
		numberField.setAllowNegative(false);
		numberField.setAllowBlank(allowBlank);
		preferredWidth = 120;

		// Decimal format
		final NumberFormat format = NumberFormat.getDecimalFormat();
		numberField.setFormat(format);

		// Sets the min value.
		final Number minValue = 0.0;
		numberField.setMinValue(minValue);

		return numberField;
	}

	/**
	 * Create a label field to represent a default flexible element.
	 * 
	 * @return The label field.
	 */
	protected LabelField createLabelField() {

		final LabelField labelField = new LabelField();
		labelField.setLabelSeparator(":");

		return labelField;
	}

	@Override
	public Object renderHistoryToken(HistoryTokenListDTO token) {

		ensureHistorable();

		final String value = token.getTokens().get(0).getValue();

		if (getType() != null) {
			switch (getType()) {
			case COUNTRY:
				if (cache != null) {
					final CountryDTO c = cache.getCountryCache().get(Integer.valueOf(value));
					if (c != null) {
						return new HistoryTokenText(c.getName());
					} else {
						return new HistoryTokenText("#" + value);
					}
				} else {
					return new HistoryTokenText("#" + value);
				}
			case START_DATE:
			case END_DATE:
				final DateTimeFormat format = DateUtils.DATE_SHORT;
				final long time = Long.valueOf(value);
				return new HistoryTokenText(format.format(new Date(time)));
			case MANAGER:
				if (cache != null) {
					final UserDTO u = cache.getUserCache().get(Integer.valueOf(value));
					if (u != null) {
						return new HistoryTokenText(u.getFirstName() != null ? u.getFirstName() + ' ' + u.getName()
										: u.getName());
					} else {
						return new HistoryTokenText("#" + value);
					}
				} else {
					return new HistoryTokenText("#" + value);
				}
			case ORG_UNIT:
				if (cache != null) {
					final OrgUnitDTOLight o = cache.getOrganizationCache().get(Integer.valueOf(value));
					if (o != null) {
						return new HistoryTokenText(o.getName() + " - " + o.getFullName());
					} else {
						return new HistoryTokenText("#" + value);
					}
				} else {
					return new HistoryTokenText("#" + value);
				}
			default:
				return super.renderHistoryToken(token);
			}
		} else {
			return super.renderHistoryToken(token);
		}
	}

}
