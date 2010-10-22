package org.activityinfo.shared.command.result;

/**
 * Result of commands which create a new entity.
 *
 * @see org.activityinfo.shared.command.CreateEntity
 * @see org.activityinfo.shared.command.CreateReportDef
 *
 * @author Alex Bertram
 */
public class CreateResult implements CommandResult {

	private int newId;

	protected CreateResult() {
		
	}
		
	public CreateResult(int newId) {
		this.newId = newId;
	}

    /**
     * Gets the primary key of the new entity.
     *
     * @return the primary key of the new entity that was generated by the server.
     */
	public int getNewId() {
		return newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

}