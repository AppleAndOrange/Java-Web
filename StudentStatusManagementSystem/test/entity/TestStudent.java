package entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudent {
@Test
public void testSchemaExport(){
	//创建配置对象
	Configuration configuration=new Configuration().configure();
//	//创建服务注册对象
//	ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//	//创建sessionFactory
//	SessionFactory sessionFactory=configuration.buildSessionFactory(registry);
//	//创建session
//	Session session=sessionFactory.getCurrentSession();
	//创建schemaExport对象
	SchemaExport schemaExport=new SchemaExport(configuration);
	schemaExport.create(true,true);
	System.out.println("测试成功");
}
}
