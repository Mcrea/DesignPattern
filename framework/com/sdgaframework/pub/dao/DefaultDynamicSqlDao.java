package com.sdgaframework.pub.dao;

import java.beans.PropertyDescriptor;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.Assert;

import com.sdgaframework.pub.domain.AbsDynamicSqlDomain;
import com.sdgaframework.pub.domain.BuildSqlDomain;
import com.sdgaframework.pub.domain.ISqlDomain;
/**
 */
@SuppressWarnings("unchecked")
public class DefaultDynamicSqlDao extends JdbcDaoSupport implements
		IDynamicSqlDao {
	private static Logger logger = Logger.getLogger("Client");

	public DefaultDynamicSqlDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int deleteByPk(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method deleteByPk");
		BuildSqlDomain  sqld   =sqlSupport.getDeleteByPkSqlAndValues();
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().update(sql, value);

	}

	@Override
	public int insert(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method insert");
		BuildSqlDomain  sqld   = sqlSupport.getInsertSqlAndValues();
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().update(sql,
				value);
	}

	@Override
	public SqlSupport selectByPk(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method selectByPk");
		BuildSqlDomain  sqld   =sqlSupport.getSelectByPkSqlAndValues();
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		List list = this.getJdbcTemplate().query(sql, value,
				new BeanPropertyRowMapper(sqlSupport.getClass()));
		return (SqlSupport) (list.isEmpty() ? getEmptyBaseDomain(sqlSupport)
				: list.get(0));

	}

	protected SqlSupport getEmptyBaseDomain(
			SqlSupport basedomain) {
		return BeanUtils.instantiate(basedomain.getClass());
	}

	@SuppressWarnings("unused")
	private String getClassName(ISqlDomain basedomain) {
		return basedomain.getClass().getName();
	}

	@Override
	public int updateByPk(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport,"null is not applicable for method updateByPk");
		BuildSqlDomain  sqld   = sqlSupport.getUpdateByPkSqlAndValues();
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().update(sql, value);
	}

	@Override
	public int deleteByWhere(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method deleteByWhere");
		BuildSqlDomain  sqld   = sqlSupport.getSqlAndValues("deleteByWhere");
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().update(sql, value);

	}

	@Override
	public List findbyWhere(SqlSupport sqlSupport,
			Class clazz) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method findByWhere");
		BuildSqlDomain  sqld   = sqlSupport.getSqlAndValues("findbyWhere");
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		List list = this.getJdbcTemplate().query(
				sql,
				value,
				new BeanPropertyRowMapper(clazz == null ? sqlSupport
						.getClass() : clazz));
		return list;
	}

	@Override
	public int updateByWhere(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method updateByWhere");
		BuildSqlDomain  sqld   =sqlSupport.getSqlAndValues("updateByWhere");
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().update(sql, value);
	}

	private String getSqlWithParameter(String sql, Object[] value) {
		if (sql == null) {
			logger.info("SQL不能为空！");
			return "请配置SQL";
		}

		if (value == null) {
			logger.info("参数值不能为空！");
			return "请传入参数值";
		}

		String ssql = new String(sql);
		for (int i = 0; i < value.length; i++) {
			ssql = ssql.replaceFirst("\\?", value[i] == null ? "null": value[i].toString());
		}
		return ssql;
	}

	public String getDynamicSqlWherePart(ISqlDomain dynamicdomain) {

		StringBuffer sql = new StringBuffer();
		BeanWrapper bw = PropertyAccessorFactory
				.forBeanPropertyAccess(dynamicdomain);

		PropertyDescriptor[] pds = BeanUtils
				.getPropertyDescriptors(dynamicdomain.getClass());
		for (PropertyDescriptor pd : pds) {
			{
				if (pd.getWriteMethod() != null) {
					String value = (String) bw.getPropertyValue(pd.getName());
					if (value != null && !"".equals(value)) {
						String tabfieldname = pd.getName().replace("get", "")
								.toLowerCase();
						if (sql.length() > 0)
							sql.append(" and ");
						sql.append(tabfieldname).append(" ='").append(value)
								.append("' ");
					}
				}
			}
		}
		if (sql.length() > 0) {
			return " where " + sql.toString();
		} else
			return "";
	}

	@Override
	public long queryForLongBynamicSql(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method queryForLongBynamicSql");
		BuildSqlDomain  sqld   =sqlSupport.getSqlAndValues("queryForLongBynamicSql");
		String sql =sqld.getSql();
		Object[] value = sqld.getObject();
		if (logger.isDebugEnabled())
			logger.info(getSqlWithParameter(sql, value));
		return this.getJdbcTemplate().queryForLong(sql, value);

	}

	@Override
	public long queryForLong(String sql) {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForLong(sql);
	}

	@Override
	public String queryForString(SqlSupport sqlSupport) {
		// TODO Auto-generated method stub
		Assert.notNull(sqlSupport, "null is not applicable for method queryForString");
		BuildSqlDomain  sqld   =sqlSupport.getSqlAndValues("queryForString");
		String sql =sqld.getSql();
		String result = (String)this.getJdbcTemplate().queryForObject(sql.toString(), String.class);
		return result;
	}


}
