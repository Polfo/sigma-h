/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.shared.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a NGO.
 * 
 * @author tmi
 * 
 */
@Entity
@Table(name = "organization")
public class Organization implements Serializable {

    private int id;
    private String name;
    private String logo;
    private OrgUnit root;
    private List<OrgUnit> orgUnit;

    public Organization() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_organization")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo", nullable = true, columnDefinition = "TEXT")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @OneToOne(optional = true)
    @JoinColumn(name = "id_root_org_unit", nullable = true)
    public OrgUnit getRoot() {
        return root;
    }

    public void setRoot(OrgUnit root) {
        this.root = root;
    }

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    public List<OrgUnit> getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(List<OrgUnit> orgUnit) {
        this.orgUnit = orgUnit;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Organization)) {
            return false;
        }

        final Organization other = (Organization) obj;

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
