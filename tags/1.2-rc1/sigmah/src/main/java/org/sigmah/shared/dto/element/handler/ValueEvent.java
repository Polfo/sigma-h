package org.sigmah.shared.dto.element.handler;

import java.io.Serializable;

import org.sigmah.client.page.project.ProjectPresenter;
import org.sigmah.shared.dto.element.FlexibleElementDTO;
import org.sigmah.shared.dto.value.ListEntityDTO;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event transmitted to the {@link ProjectPresenter} when a flexible element
 * value changes.
 * 
 * @author Denis Colliot (dcolliot@ideia.fr)
 * 
 */
/**
 * @author HUZHE
 *
 */

public class ValueEvent extends GWTImmortalEvent<ValueHandler> implements Serializable {

    private static final long serialVersionUID = -6920472009097129066L;

    private final static GwtEvent.Type<ValueHandler> TYPE = new GwtEvent.Type<ValueHandler>();

    private FlexibleElementDTO sourceElement;
    private ListEntityDTO listValue;
    private String singleValue;
    // Only used for the elements part of a list.
    private ChangeType changeType;
    boolean isProjectCountryChanged=false;

    public ValueEvent(FlexibleElementDTO sourceElement, String singleValue) {
        this.sourceElement = sourceElement;
        this.singleValue = singleValue;
    }
    
    
    /**
     * 
     * ValueEvent that is unique for OrgUnit DefaultFlexibleElement 
     * 
     * @param orgUnitElement
     *          OrgUnit DefaultFlxibleElement
     *          
     * @param singleValue
     *          Name of OrgUnit
     * 
     * @param isProjectCountryChanged
     *          If the OrgUnit element is attached to a project,specify if you want to change the OrgUnit of the project
     *          by the new orgunit's country,or just change the OrgUnit without touching the country of project.
     */
    public ValueEvent(FlexibleElementDTO orgUnitElement, String singleValue,boolean isProjectCountryChanged) {
        this.sourceElement = orgUnitElement;
        this.singleValue = singleValue;
        this.isProjectCountryChanged=isProjectCountryChanged;
    }


    public ValueEvent(FlexibleElementDTO sourceElement, ListEntityDTO listValue) {
        this.sourceElement = sourceElement;
        this.listValue = listValue;
        this.changeType = ChangeType.ADD;
    }

    public ValueEvent(FlexibleElementDTO sourceElement, ListEntityDTO listValue, ChangeType changeType) {
        this.sourceElement = sourceElement;
        this.listValue = listValue;
        if (changeType == null) {
            this.changeType = ChangeType.ADD;
        } else {
            this.changeType = changeType;
        }
    }

    @Override
    protected void dispatch(ValueHandler handler) {
        handler.onValueChange(this);
    }

    @Override
    public GwtEvent.Type<ValueHandler> getAssociatedType() {
        return TYPE;
    }

    public static Type<ValueHandler> getType() {
        return TYPE;
    }

    public void setSourceElement(FlexibleElementDTO sourceElement) {
        this.sourceElement = sourceElement;
    }

    public FlexibleElementDTO getSourceElement() {
        return sourceElement;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public ListEntityDTO getListValue() {
        return listValue;
    }

    public void setListValue(ListEntityDTO listValue) {
        this.listValue = listValue;
    }

    public String getSingleValue() {
        return singleValue;
    }

    public void setSingleValue(String singleValue) {
        this.singleValue = singleValue;
    }

    
    
    /**
	 * @return the isProjectCountryChanged
	 */
	public boolean isProjectCountryChanged() {
		return isProjectCountryChanged;
	}


	/**
	 * @param isProjectCountryChanged the isProjectCountryChanged to set
	 */
	public void setProjectCountryChanged(boolean isProjectCountryChanged) {
		this.isProjectCountryChanged = isProjectCountryChanged;
	}


	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ValueEvent [");
        sb.append("source=#");
        sb.append(sourceElement.getId());
        sb.append(",value=");
        sb.append(singleValue);
        sb.append(",values=");
        sb.append(listValue);
        sb.append(",changeType=");
        sb.append(changeType);
        sb.append("]\n");
        return sb.toString();
    }

    public static enum ChangeType {
        ADD, REMOVE, EDIT;
    }
}
