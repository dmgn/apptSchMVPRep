package app.cal.schedule.business.cmd;
import java.util.Date;

import org.springframework.stereotype.Component;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.SystemMessages;
import app.cal.schedule.api.SystemNotification;


@Component
public class HandlerContextFactory {

	public HandlerContext createContext(){
		
		return new HandlerContextImpl();
	}
	
	public static class HandlerContextImpl implements HandlerContext{

		private final SystemMessages messages = new SystemMessages();
		private String referenceId;
		private int version;
		private Date lastUpdated;
		private String reqId;
		
		@Override
		public BaseMessage buildResponse() {
			final BaseMessage bm = new BaseMessage();
			bm.setLastUpdated(lastUpdated);
			bm.setReferenceId(referenceId);
			bm.setRequestId(reqId);
			bm.setSystemMessages(messages);
			bm.setVersion(version);
			bm.setResultStatus("OK");
			return bm;
		}

		@Override
		public void addError(SystemNotification error) {
			messages.addError(error);
		}

		@Override
		public void addWarning(SystemNotification warn) {
			messages.addWarn(warn);
		}

		@Override
		public void addInfo(SystemNotification info) {
			messages.addInfo(info);
		}

		@Override
		public void addReferenceId(String refId) {
			this.referenceId = refId;
		}

		@Override
		public void addNewVersion(int version) {
			this.version = version;
		}

		@Override
		public void addLastUpdated(Date date) {
			this.lastUpdated = date;
		}

		public boolean hasErrors(){
			return messages.hasErrors();
		}
	}
}
