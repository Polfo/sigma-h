package org.sigmah.shared.domain.logframe;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.sigmah.shared.domain.Indicator;

/**
 * Base class for all LogFrame elements, such as SpecificObjective, Activity, etc
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LogFrameElement implements Serializable, Comparable<LogFrameElement> {
	private Integer id;
	protected Integer code;
	protected Integer position;
	protected LogFrameGroup group;
	protected String risks;
	protected String assumptions;
	private Set<Indicator> indicators;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_objective")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "code", nullable = false)
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Column(name = "position")
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_group", nullable = true)
	public LogFrameGroup getGroup() {
		return group;
	}

	public void setGroup(LogFrameGroup group) {
		this.group = group;
	}

	@Column(name = "risks", columnDefinition = "TEXT")
	public String getRisks() {
		return risks;
	}

	public void setRisks(String risks) {
		this.risks = risks;
	}

	@Column(name = "assumptions", columnDefinition = "TEXT")
	public String getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(String assumptions) {
		this.assumptions = assumptions;
	}

	@ManyToMany
	@JoinTable(name = "log_frame_indicators")
	public Set<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(Set<Indicator> indicators) {
		this.indicators = indicators;
	}

	@Override
	public int compareTo(LogFrameElement o) {
		int c1 = getCode() == null ? 0 : getCode();
		int c2 = o.getCode() == null ? 0 : o.getCode();
		
		return c1 - c2;
	}
}
