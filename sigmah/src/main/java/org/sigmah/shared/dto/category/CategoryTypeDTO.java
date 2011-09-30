package org.sigmah.shared.dto.category;

import java.util.List;

import org.sigmah.shared.domain.category.CategoryIcon;
import org.sigmah.shared.dto.EntityDTO;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class CategoryTypeDTO extends BaseModelData implements EntityDTO {

    private static final long serialVersionUID = 4190439829705158136L;

    @Override
    public String getEntityName() {
        return "category.CategoryType";
    }

    // Type id
    @Override
    public int getId() {
        return (Integer) (get("id") != null ? get("id") : -1);
    }

    public void setId(int id) {
        set("id", id);
    }

    // Type label
    public String getLabel() {
        return get("label");
    }

    public void setLabel(String label) {
        set("label", label);
    }

    // Category elements list
    public List<CategoryElementDTO> getCategoryElementsDTO() {
        return get("categoryElementsDTO");
    }

    public void setCategoryElementsDTO(List<CategoryElementDTO> categoryElementsDTO) {
        set("categoryElementsDTO", categoryElementsDTO);
    }

    // Icon name
    public CategoryIcon getIcon() {
        return get("icon");
    }

    public void setIcon(CategoryIcon icon) {
        set("icon", icon);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CategoryTypeDTO)) {
            return false;
        }

        final CategoryTypeDTO other = (CategoryTypeDTO) obj;

        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
