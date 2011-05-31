package org.sigmah.shared.domain.logframe;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.sigmah.shared.domain.Deleteable;

/**
 * Represents an item of the prerequisites list of a log frame.
 * 
 * @author tmi
 * 
 */
@Entity
@Table(name = "log_frame_prerequisite")
public class Prerequisite implements Serializable {

    private static final long serialVersionUID = -3093621922617967414L;

    private Integer id;
    private Integer code;
    private String content;
    private LogFrame parentLogFrame;
    private LogFrameGroup group;
    private Integer position;

    /**
     * Duplicates this prerequisite (omits the ID).
     * @param parentLogFrame Log frame that will contains this copy.
     * @param context Map of copied groups.
     * @return A copy of this prerequisite.
     */
    public Prerequisite copy(final LogFrame parentLogFrame, final LogFrameCopyContext context) {
        final Prerequisite copy = new Prerequisite();
        copy.code = this.code;
        copy.content = this.content;
        copy.parentLogFrame = parentLogFrame;
        copy.group = context.getGroupCopy(this.group);
        copy.position = this.position;

        return copy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prerequisite")
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

    @Column(name = "content", columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_log_frame", nullable = true)
    public LogFrame getParentLogFrame() {
        return parentLogFrame;
    }

    public void setParentLogFrame(LogFrame parentLogFrame) {
        this.parentLogFrame = parentLogFrame;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_group", nullable = false)
    public LogFrameGroup getGroup() {
        return group;
    }

    public void setGroup(LogFrameGroup group) {
        this.group = group;
    }

    @Column(name = "position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
