package app.cal.schedule.business.dao.jdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class TutorScheduleParamBuilder {

	MapSqlParameterSource map = new MapSqlParameterSource();
	StringBuffer sql = new StringBuffer();
	
	
	public TutorScheduleParamBuilder( String sql){
		this.sql.append(sql);
	}
	
	public TutorScheduleParamBuilder withProductId(long productId){
		sql.append(" AND PI.PRODUCT_ID = :prodId");
		map.addValue("prodId", productId);
		return this;
	}
	
	public TutorScheduleParamBuilder withLocationId(long locationId){
		sql.append(" AND LWH.LOCATION_ID = :locId");
		map.addValue("locId", locationId);
		return this;
	}
	
	public TutorScheduleParamBuilder withOrderBy(){
		sql.append( " ORDER BY TS.SCHEDULE_DATE, LWH.START_TIME " );
		return this;
	}

	public MapSqlParameterSource getMap() {
		return map;
	}

	public StringBuffer getSql() {
		return sql;
	}	
	
}
