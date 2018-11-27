package com.sdgaframework.pub.dao;

import com.sdgaframework.pub.domain.AbsDynamicSqlDomain;

/**
 * The root interface for accessing a danymic sql dao.

 *<p>本接口定义了下列方法，实现了动态sql和静态sql的执行
 *<p>本接口一般用于数据的操作，要求表定义的字段名称和领域对象的字段名称一致;
 *<p>字段类型的转换，在AbsDynamicSqlDomain的子类的相应方法内进行转换，可能存在转换异常
 */
public interface IDynamicSqlDao {
	/**
	 * 返回插入数据的行数
	 * <p>本方法把一个IDynamicSqlDomain的数据存入数据库或者其他地方
	 * @param dynamicdomain 一个领域对象
	 * @return 一个整数
	 * @throws DaoAcecssException  or other Exception
	 * with the specified name
	 */
	   public int insert (SqlSupport sqlSupport);
	   /**
	     * 根据主键查询数据
		 *<p>系统根据dynamicdomain的类型和whichKey找到配置文件中的selectpk sql语句，
		 *<p>然后根据dynamicdomain中的getPkValues找到主键参数值
		 * @param basedomain 一个领域对象
		 * @return basedomain 一个领域对象
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
	   public  SqlSupport  selectByPk(SqlSupport sqlSupport);
	   /**
	     *根据主键删除数据
		 *<p>系统根据dynamicdomain的类型和whichKey找到配置文件中的deletepk sql语句，
		 * <p>然后根据dynamicdomain中的getPkValues找到主键参数值
		 * @param DynamicSqlDomain 一个领域对象
		 * @return 删除的数据数据量
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
	   public int deleteByPk (SqlSupport sqlSupport);
	  
	   /**
	    * 根据主键更新数据
		 *<p>系统根据dynamicdomain的类型和whichKey找到配置文件中的updatepk sql语句，
		 * <p>然后根据dynamicdomain中的getUpdatePkValues找到对应的参数值
		 * @param basedomain 一个领域对象
		 * @return 一个整数
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
	   public int updateByPk (SqlSupport sqlSupport);
	   /**
		 * 根据已经构造好的动态sql和对应动态sql对应的参数值，查询相应的数据
		 * <p>例如sql=“select * from user where userid=? and username=?"
		 * <p>sqlvalues =new object[]{"001","wangli"}
		 * @param basedomain 一个领域对象
		 * @return List 0个以上BaseParameterDomain对象
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
//	   public java.util.List findbyWhere (String sql  ,Object[] sqlvalues,Class clazz);
//	   /**
//		 * 根据已经构造好的动态sql和对应动态sql对应的参数值，更新相应的数据
//		 * <p>例如sql=“update user set userid=? where userid=? and username=?"
//		 * <p>sqlvalues =new object[]{"001","001","wangli"}
//		 * @param basedomain 一个领域对象
//		 * @return 包含clazz类型的对象
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
	   
	   public java.util.List findbyWhere (SqlSupport sqlSupport,Class clazz);
	   /**
		 * 根据已经构造好的动态sql和对应动态sql对应的参数值，删除相应的数据
		 * <p>例如sql=“update user set username=? where userid=? and username=?"
		 * <p>sqlvalues =new object[]{"王黎"，"001","wangli"}
		 * @param basedomain 一个领域对象
		 * @return 更新的数据量
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
//	   public int updateByWhere (String sql  ,Object[] sqlvalues);
//	   
//	   /**
//		 * 
//		 * <p>系统根据dynamicdomain的类型和whichKey找到配置文件中的sql语句，
//		 * <p>然后根据dynamicdomain中的getWhereValues（whicKey)找到对应的参数值
//		 * @param dynamicdomain 一个领域对象，whichKey对应的sql语句的关键字
//		 * @return 包含clazz类型的对象
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
  public int updateByWhere (SqlSupport sqlSupport);
	   
	   /**
		 * 根据已经构造好的动态sql和对应动态sql对应的参数值，删除相应的数据
		 * <p>例如sql=“update user set username=? where userid=? and username=?"
		 * <p>sqlvalues =new object[]{"王黎"，"001","wangli"}
		 * @paramString sql  ,Object[] sqlvalues
		 * @return 删除的数据量
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
	   
//	   public int deleteByWhere (String sql  ,Object[] sqlvalues);
//	   /**
//		* <p>根据dynamicdomain的类型和whichKey找到配置文件中的sql语句，
//		 * <p>然后根据dynamicdomain中的getWhereValues（whicKey)找到对应的参数值
//		 * @param  AbsDynamicSqlDomain dynamicdomain,String whichKey
//		 * @return 删除的数据量
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
	   
	   public int deleteByWhere (SqlSupport sqlSupport);
	   /**
		 * 根据已经构造好的静态sql和sql查询对应的领域对象的类型
		 * <p>例如sql=“select glbm, count(*) num from vehicle where ....."
		 * <p>定义一个有glbm，num两个属性的类 
		 * @param sql 定义好的sql claszz 领域对象的类型
		 * @return 一个包含上述类的List
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
//	   public java.util.List findByAnysql  (String sql,Class  clazz);
//	   
//	   /**
//		 * 根据领域对象的值是否为空构造sql的where部分
//		 * <p>根据 whichKey 返回的sql=“select *  from vehicle ";构造完整的sql
//		 * <p>假如：定义一个包含有hpzl，hphm两个属性的类 ，其中只有这两个属性不为空最后的sql为 则 "select *  from vehicle  where hpzl='01' and hphm='A9999'"
//		 * @param  领域对象和 whichKey
//		 * @return 一个包含上述类的List
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
//	   public java.util.List  findByAnyDomainValue(AbsDynamicSqlDomain dynamicdomain,String whichKey,Class clazz);
//	   
//	   
//	   /**
//		 * 根据sql select count(*) from tabname 
//		 * <p>
//		 * <p>
//		 * @param  sql=select count(*) from tabname 
//		 * @return 查询的数据量
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
	   public long  queryForLong(String sql);
	   
	   /**
		 * 根据领域对象的值是否为空构造sql的where部分
		 * <p>根据 whichKey 返回的sql=“select *  from vehicle ";构造完整的sql
		 * <p>假如：定义一个包含有hpzl，hphm两个属性的类 ，其中只有这两个属性不为空最后的sql为 则 "select *  from vehicle  where hpzl='01' and hphm='A9999'"
		 * @param  领域对象和 whichKey
		 * @return 一个包含上述类的List
		 * @throws DaoAcecssException  or other Exception
		 * with the specified name
		 */
//	   public java.util.List  findByDynamicSql(IBuildSql buildsql,String whichKey,Class clazz);
//	   /**
//		 * 根据领域对象的值是否为空构造sql的where部分求总数
//		 * <p>假如：where条件为where hpzl='01' and hphm='A9999'；则 "select count(*)  from vehicle  where hpzl='01' and hphm='A9999'"
//		 * @param  领域对象和 whichKey
//		 * @return 一个包含上述类的long
//		 * @throws DaoAcecssException  or other Exception
//		 * with the specified name
//		 */
	   public long queryForLongBynamicSql(SqlSupport sqlSupport);
	   
	   public String queryForString(SqlSupport sqlSupport);
	   
}
