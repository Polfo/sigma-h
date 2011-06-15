/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.shared.dto;

import java.util.List;

import org.sigmah.shared.dto.layout.LayoutDTO;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.user.client.ui.Widget;

public class PhaseModelDTO extends BaseModelData implements EntityDTO {

    private static final long serialVersionUID = 8520711106031085130L;

    @Override
    public String getEntityName() {
        return "Phase model";
    }

    // Phase model id
    @Override
    public int getId() {
    	final Integer id = (Integer) get("id");
        return id != null ? id : -1;
    }

    public void setId(int id) {
        set("id", id);
    }

    // Phase model name
    public String getName() {
        return get("name");
    }

    public void setName(String name) {
        set("name", name);
    }

    // Reference to parent project model DTO
    public ProjectModelDTO getParentProjectModelDTO() {
        return get("parentProjectModelDTO");
    }

    public void setParentProjectModelDTO(ProjectModelDTO parentProjectModelDTO) {
        set("parentProjectModelDTO", parentProjectModelDTO);
    }

    // Reference to layout
    public LayoutDTO getLayoutDTO() {
        return get("layoutDTO");
    }

    public void setLayoutDTO(LayoutDTO layoutDTO) {
        set("layoutDTO", layoutDTO);
    }

    // Reference to the phases successors
    public List<PhaseModelDTO> getSuccessorsDTO() {
        return get("successorsDTO");
    }

    public void setSuccessorsDTO(List<PhaseModelDTO> successorsDTO) {
        set("successorsDTO", successorsDTO);
    }

    // Display order
    public int getDisplayOrder() {
        return (Integer) get("displayOrder");
    }

    public void setDisplayOrder(int displayOrder) {
        set("displayOrder", displayOrder);
    }

    // Definition
    public PhaseModelDefinitionDTO getDefinitionDTO() {
        return get("definitionDTO");
    }

    public void setDefinitionDTO(PhaseModelDefinitionDTO definitionDTO) {
        set("definitionDTO", definitionDTO);
    }

    // Guide
    public String getGuide() {
        return get("guide");
    }

    public void setGuide(String guide) {
        set("guide", guide);
    }
    
    public Boolean isRoot(){
    	return get("root");
    }
    
    public void setIsRoot(Boolean isRoot){
    	set("root", isRoot);
    }

    /**
     * Returns if a guide is available for this phase model.
     * 
     * @return If a guide is available for this phase model.
     */
    public boolean isGuideAvailable() {
        final String guide = get("guide");
        return guide != null && !"".equals(guide.trim());
    }

    public Widget getWidget() {
        return getLayoutDTO().getWidget();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof PhaseModelDTO)) {
            return false;
        }

        final PhaseModelDTO other = (PhaseModelDTO) obj;

        return getId() == other.getId();
    }
}
