package daoImpl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class CustomSQLResponse {
	private List<Map<String, Object>> result;
	private int affectedRows;
	private boolean error;
	private Date executedAt;
	
	public CustomSQLResponse() {
		
	}
	public CustomSQLResponse(List<Map<String, Object>> result, int affectedRows, boolean error, Date executedAt) {
		if(untouched) {
			this.result = result;
			this.affectedRows = affectedRows;
			this.error = error;
			this.executedAt = executedAt;
			untouched = false;
		}
	}
	private boolean untouched = true;
	
	public boolean setData(List<Map<String, Object>> result, int affectedRows, boolean error, Date executedAt) {
		if(untouched) {
			this.result = result;
			this.affectedRows = affectedRows;
			this.error = error;
			this.executedAt = executedAt;
			untouched = false;
			return true;
		} return false;
	}
	
	public List<Map<String, Object>> getResult() {return this.result; }
	public int getAffectedRows() {return this.affectedRows; }
	public boolean anyError() {return this.error;}
	public Date getExecutionDate() {return this.executedAt; }
	
}
