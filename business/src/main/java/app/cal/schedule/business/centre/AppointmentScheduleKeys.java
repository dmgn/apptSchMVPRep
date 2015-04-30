package app.cal.schedule.business.centre;

import java.util.Date;

public class AppointmentScheduleKeys {
	
	
		private Date scheduleDate;
		
		private long timeSlotId;

		public Date getScheduleDate() {
			return scheduleDate;
		}

		public void setScheduleDate(Date scheduleDate) {
			this.scheduleDate = scheduleDate;
		}

		public long getTimeSlotId() {
			return timeSlotId;
		}

		public void setTimeSlotId(long timeSlotId) {
			this.timeSlotId = timeSlotId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((scheduleDate == null) ? 0 : scheduleDate.hashCode());
			result = prime * result + (int) (timeSlotId ^ (timeSlotId >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AppointmentScheduleKeys other = (AppointmentScheduleKeys) obj;
			if (scheduleDate == null) {
				if (other.scheduleDate != null)
					return false;
			} else if (!scheduleDate.equals(other.scheduleDate))
				return false;
			if (timeSlotId != other.timeSlotId)
				return false;
			return true;
		}

		
		

}
