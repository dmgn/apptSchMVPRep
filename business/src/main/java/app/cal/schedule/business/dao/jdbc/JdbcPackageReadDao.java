package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.PackageDetails;

@Repository
public class JdbcPackageReadDao implements PackageReadDao{

	NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcPackageReadDao() {}
	
	public JdbcPackageReadDao( DataSource datasource ) {
		jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	@Override
	public PackageDetails findPackageByRefId(String refId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListMessage<PackageDetails> findAllPackageFor(long corpId) {
		final String sql = "SELECT * FROM PACKAGE_INFO WHERE CORPORATE_ID=:corpId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<PackageDetails> pkgDtlsList = jdbcTemplate.query(sql, map, new PackageDetailsRowMapper());
		return new ListMessage<>(pkgDtlsList);	
	}

	private class PackageDetailsRowMapper implements RowMapper<PackageDetails>{
		@Override
		public PackageDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PackageDetails pkgDtls = new PackageDetails();
			pkgDtls.setPackageId(rs.getLong("PACKAGE_ID"));
			pkgDtls.setPackageName(rs.getString("PACKAGE_NAME"));
			pkgDtls.setPackageOfferCode(rs.getString("PACKAGE_OFFER_CODE"));
			pkgDtls.setPackageDesc(rs.getString("PACKAGE_DESC"));
			pkgDtls.setPackageDuration(rs.getInt("PACKAGE_DURATION"));
			pkgDtls.setReferenceId(rs.getString("REF_ID"));
			pkgDtls.setVersion(rs.getInt("VERSION"));
			pkgDtls.setLastUpdated(rs.getDate("UPDATE_DATE"));
			return pkgDtls;			
		}		
	}
}
