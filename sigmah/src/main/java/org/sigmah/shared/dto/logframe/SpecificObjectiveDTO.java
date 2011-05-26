package org.sigmah.shared.dto.logframe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sigmah.client.page.project.logframe.grid.Row.Positionable;
import org.sigmah.shared.dto.EntityDTO;

import com.extjs.gxt.ui.client.data.BaseModelData;

/**
 * DTO mapping class for entity logframe.SpecificObjective.
 * 
 * @author tmi
 * 
 */
public class SpecificObjectiveDTO extends BaseModelData implements EntityDTO, Positionable {

    private static final long serialVersionUID = -5441820698955180264L;

    public SpecificObjectiveDTO() {
    	setExpectedResultsDTO(new ArrayList<ExpectedResultDTO>());
    }
    
    @Override
    public String getEntityName() {
        return "logframe.SpecificObjective";
    }

    // Objective id.
    @Override
    public int getId() {
        final Integer id = (Integer) get("id");
        return id != null ? id : -1;
    }

    public void setId(int id) {
        set("id", id);
    }

    // Objective code.
    public Integer getCode() {
        return get("code");
    }

    public void setCode(Integer code) {
        set("code", code);
    }

    // Objective position in its group.
    public Integer getPosition() {
        return get("position");
    }

    @Override
    public void setPosition(Integer position) {
        set("position", position);
    }

    // Objective intervention logic.
    public String getInterventionLogic() {
        return get("interventionLogic");
    }

    public void setInterventionLogic(String interventionLogic) {
        set("interventionLogic", interventionLogic);
    }

    // Objective risks.
    public String getRisks() {
        return get("risks");
    }

    public void setRisks(String risks) {
        set("risks", risks);
    }

    // Objective assumptions.
    public String getAssumptions() {
        return get("assumptions");
    }

    public void setAssumptions(String assumptions) {
        set("assumptions", assumptions);
    }

    // Objective expected results.
    public List<ExpectedResultDTO> getExpectedResultsDTO() {
        return get("expectedResultsDTO");
    }

    public void setExpectedResultsDTO(List<ExpectedResultDTO> expectedResultsDTO) {
        set("expectedResultsDTO", expectedResultsDTO);
    }


    // Objective parent log frame.
    public LogFrameDTO getParentLogFrameDTO() {
        return get("parentLogFrameDTO");
    }

    public void setParentLogFrameDTO(LogFrameDTO parentLogFrameDTO) {
        set("parentLogFrameDTO", parentLogFrameDTO);
    }

    // Objective group.
    public LogFrameGroupDTO getLogFrameGroupDTO() {
        return get("logFrameGroupDTO");
    }

    public void setLogFrameGroupDTO(LogFrameGroupDTO logFrameGroupDTO) {
        set("logFrameGroupDTO", logFrameGroupDTO);
    }

    // Display label.
    /**
     * Sets the attribute <code>label</code> to display this element in a
     * selection window.
     */
    public void setLabel(String label) {
        set("label", label);
    }

    public String getLabel() {
        return get("label");
    }

  
    /**
     * Gets the client-side id for this entity. If this entity has a server-id
     * id, it's returned. Otherwise, a temporary id is generated and returned.
     * 
     * @return The client-side id.
     */
    public int getClientSideId() {

        // Server-side id.
        Integer id = (Integer) get("id");

        if (id == null) {

            // Client-side id.
            id = (Integer) get("tmpid");

            // Generates the client-side id once.
            if (id == null) {
                id = generateClientSideId();
            }
        }

        return id;
    }

    /**
     * Generate a client-side unique id for this entity and stores it in the
     * <code>temporaryId</code> attribute.
     */
    private int generateClientSideId() {
        final int id = (int) new Date().getTime();
        set("tmpid", id);
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SpecificObjectiveDTO [");
        sb.append("entity name = ");
        sb.append(getEntityName());
        sb.append(" ; id = ");
        sb.append(getId());
        sb.append(" ; group id = ");
        if (getLogFrameGroupDTO() != null) {
            sb.append(getLogFrameGroupDTO().getId() != -1 ? getLogFrameGroupDTO().getId() : getLogFrameGroupDTO()
                    .getClientSideId());
        }
        sb.append(" ; dlabel = ");
        sb.append(getLabel());
        sb.append(" ; code = ");
        sb.append(getCode());
        sb.append(" ; intervention logic = ");
        sb.append(getInterventionLogic());
        sb.append(" ; risks = ");
        sb.append(getRisks());
        sb.append(" ; assumptions = ");
        sb.append(getAssumptions());
        sb.append(" ; expected results = (\n");
        if (getExpectedResultsDTO() != null) {
            for (final ExpectedResultDTO r : getExpectedResultsDTO()) {
                sb.append(r);
                sb.append("\n");
            }
        }
        sb.append(")]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return getClientSideId();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof SpecificObjectiveDTO)) {
            return false;
        }

        final SpecificObjectiveDTO other = (SpecificObjectiveDTO) obj;
        return getClientSideId() == other.getClientSideId();
    }

    /**
     * Adds a new expected result to this log frame.
     * 
     * @return The new expected result.
     */
    public ExpectedResultDTO addExpectedResult() {

        List<ExpectedResultDTO> expectedResults = getExpectedResultsDTO();

        // Retrieves the higher code.
        int max = 0;
        for (final ExpectedResultDTO result : expectedResults) {
            max = result.getCode() > max ? result.getCode() : max;
        }

        // Creates the expected result.
        final ExpectedResultDTO newResult = new ExpectedResultDTO();
        newResult.setCode(max + 1);
        newResult.setParentSpecificObjectiveDTO(this);

        // Adds it to the local list.
        expectedResults.add(newResult);

        return newResult;
    }

    /**
     * Removes an expected result from this objective.
     * 
     * @param result
     *            The result to remove.
     * @return If the result has been removed.
     */
    public boolean removeExpectedResult(ExpectedResultDTO result) {
    	return getExpectedResultsDTO().remove(result);
    }
}
