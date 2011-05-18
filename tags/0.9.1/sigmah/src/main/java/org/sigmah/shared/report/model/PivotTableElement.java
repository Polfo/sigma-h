/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.shared.report.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.sigmah.shared.report.content.PivotContent;

public class PivotTableElement extends PivotElement<PivotContent> {

	private List<Dimension> columnDimensions = new ArrayList<Dimension>();
    private List<Dimension> rowDimensions = new ArrayList<Dimension>();

	public PivotTableElement() {
		
	}

    @XmlElement(name="dimension")
    @XmlElementWrapper(name="columns")
	public List<Dimension> getColumnDimensions() {
		return columnDimensions;
	}

	public void setColumnDimensions(List<Dimension> columnDimensions) {
		this.columnDimensions = columnDimensions;
	}
	
	public void addColDimension(Dimension dim) {
		this.columnDimensions.add(dim);
	}
	
	public void addColDimensions(Collection<Dimension> dims) {
		this.columnDimensions.addAll(dims);
	}

    @XmlElement(name="dimension")
    @XmlElementWrapper(name="rows")
	public List<Dimension> getRowDimensions() {
		return rowDimensions;
	}

	public void setRowDimensions(List<Dimension> rowDimensions) {
		this.rowDimensions = rowDimensions;
	}
	
	public void addRowDimension(Dimension dim) {
		this.rowDimensions.add(dim);
	}
	
	public void addRowDimensions(Collection<Dimension> dims) {
		this.rowDimensions.addAll(dims);
	}
	
	@Override
	public Set<Dimension> allDimensions() {
		Set<Dimension> set = new HashSet<Dimension>();
		set.addAll(columnDimensions);
		set.addAll(rowDimensions);
		
		return set;
	}

}
