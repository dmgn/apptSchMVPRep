package app.cal.schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.ContextAwareCommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateClientEnrollment;
import app.cal.schedule.business.cmd.CreateClientEnrollmentCommandHandler;
import app.cal.schedule.business.cmd.CreateClientInfo;
import app.cal.schedule.business.cmd.CreateClientInfoCommandHandler;
import app.cal.schedule.business.cmd.CreateClientSchedule;
import app.cal.schedule.business.cmd.CreateClientScheduleBatch;
import app.cal.schedule.business.cmd.CreateClientScheduleBatchCommandHandler;
import app.cal.schedule.business.cmd.CreateClientScheduleCommandHandler;
import app.cal.schedule.business.cmd.CreateClientSvcPkg;
import app.cal.schedule.business.cmd.CreateClientSvcPkgCommandHandler;
import app.cal.schedule.business.cmd.CreateCorporateInfo;
import app.cal.schedule.business.cmd.CreateCorporateInfoCommandHandler;
import app.cal.schedule.business.cmd.CreateLocWrkHrs;
import app.cal.schedule.business.cmd.CreateLocWrkHrsCommandHandler;
import app.cal.schedule.business.cmd.CreatePackage;
import app.cal.schedule.business.cmd.CreatePackageCommandHandler;
import app.cal.schedule.business.cmd.CreateProduct;
import app.cal.schedule.business.cmd.CreateProductCommandHandler;
import app.cal.schedule.business.cmd.CreateTutor;
import app.cal.schedule.business.cmd.CreateTutorCommandHandler;
import app.cal.schedule.business.cmd.CreateTutorSchedule;
import app.cal.schedule.business.cmd.CreateTutorScheduleCommandHandler;
import app.cal.schedule.business.cmd.DeleteClientScheduleCommand;
import app.cal.schedule.business.cmd.DeleteClientScheduleInfoCommandHandler;
import app.cal.schedule.business.cmd.DeleteClientSvcPkg;
import app.cal.schedule.business.cmd.DeleteClientSvcPkgCommandHandler;
import app.cal.schedule.business.cmd.DeleteCorporateInfo;
import app.cal.schedule.business.cmd.DeleteCorporateInfoCommandHandler;
import app.cal.schedule.business.cmd.DeletePackage;
import app.cal.schedule.business.cmd.DeletePackageCommandHandler;
import app.cal.schedule.business.cmd.DeleteProduct;
import app.cal.schedule.business.cmd.DeleteProductCommandHandler;
import app.cal.schedule.business.cmd.DeleteTutor;
import app.cal.schedule.business.cmd.DeleteTutorCommandHandler;
import app.cal.schedule.business.cmd.DeleteTutorSchedule;
import app.cal.schedule.business.cmd.DeleteTutorScheduleCommandHandler;
import app.cal.schedule.business.cmd.EditClientSvcPkg;
import app.cal.schedule.business.cmd.EditClientSvcPkgCommandHandler;
import app.cal.schedule.business.cmd.EditCorporateInfo;
import app.cal.schedule.business.cmd.EditCorporateInfoCommandHandler;
import app.cal.schedule.business.cmd.EditPackage;
import app.cal.schedule.business.cmd.EditPackageCommandHandler;
import app.cal.schedule.business.cmd.EditProduct;
import app.cal.schedule.business.cmd.EditProductCommandHandler;
import app.cal.schedule.business.cmd.EditTutor;
import app.cal.schedule.business.cmd.EditTutorCommandHandler;
import app.cal.schedule.business.cmd.EditTutorSchedule;
import app.cal.schedule.business.cmd.EditTutorScheduleCommandHandler;
import app.cal.schedule.business.cmd.HandlerContextFactory;

@Configuration
public class CommandHandlerConfig {

	@Autowired
	private DaoConfig daoConfig;

	@Bean
	public HandlerContextFactory handlerContextFactory(){
		return new HandlerContextFactory();
	}

	@Bean
	public CommandHandlerFactory commandHandlerFactory(){
		final CommandHandlerFactory factory = new ContextAwareCommandHandlerFactory();
		factory.register(CreateProduct.class.getName(), createProductCmdHandler());
		factory.register(DeleteProduct.class.getName(), deleteProductCmdHandler());
		factory.register(EditProduct.class.getName(), editProductCmdHandler());
		factory.register(CreatePackage.class.getName(), createPackageCmdHandler());
		factory.register(DeletePackage.class.getName(), deletePackageCmdHandler());
		factory.register(EditPackage.class.getName(), editPackageCmdHandler());
		factory.register(CreateCorporateInfo.class.getName(), createCorporateInfoCmdHandler());
		factory.register(DeleteCorporateInfo.class.getName(), deleteCorporateInfoCmdHandler());
		factory.register(EditCorporateInfo.class.getName(), editCorporateInfoCmdHandler());
		factory.register(CreateTutor.class.getName() , createTutorCmdHandler());
		factory.register(DeleteTutor.class.getName() , deleteTutorCmdHandler());
		factory.register(EditTutor.class.getName() , editTutorCmdHandler());
		factory.register(CreateClientInfo.class.getName(), createClientInfoCmdHandler());
		factory.register(CreateClientEnrollment.class.getName(), createClientEnrollmentCmdHandler());
		factory.register(CreateLocWrkHrs.class.getName(), createLocWrkHrsCmdHandler());
		factory.register(CreateTutorSchedule.class.getName(), createTutorScheduleCmdHandler());
		factory.register(DeleteTutorSchedule.class.getName(), deleteTutorScheduleCmdHandler());
		factory.register(EditTutorSchedule.class.getName(), editTutorScheduleCmdHandler());
		factory.register(CreateClientSvcPkg.class.getName(), createClientSvcPkgCommandHandler());
		factory.register(DeleteClientSvcPkg.class.getName(), deleteClientSvcPkgCommandHandler());
		factory.register(EditClientSvcPkg.class.getName(), editClientSvcPkgCommandHandler());
		factory.register(CreateClientSchedule.class.getName(), createClientScheduleCommandHandler());
		factory.register(DeleteClientScheduleCommand.class.getName(), deleteClientScheduleCommandHandler());
		factory.register(CreateClientScheduleBatch.class.getName(), createClientScheduleBatchCommandHandler());
		return factory;
	}

	@Bean
	public CreateProductCommandHandler createProductCmdHandler(){
		return new CreateProductCommandHandler( daoConfig.productDao() );
	}

	@Bean
	public DeleteProductCommandHandler deleteProductCmdHandler(){
		return new DeleteProductCommandHandler( daoConfig.productDao());
	}

	@Bean
	public EditProductCommandHandler editProductCmdHandler(){
		return new EditProductCommandHandler( daoConfig.productDao());
	}

	@Bean
	public CreatePackageCommandHandler createPackageCmdHandler(){
		return new CreatePackageCommandHandler( daoConfig.packageDao() );
	}

	@Bean
	public DeletePackageCommandHandler deletePackageCmdHandler(){
		return new DeletePackageCommandHandler( daoConfig.packageDao() );
	}

	@Bean
	public EditPackageCommandHandler editPackageCmdHandler(){
		return new EditPackageCommandHandler( daoConfig.packageDao() );
	}
	
	@Bean
	public CreateCorporateInfoCommandHandler createCorporateInfoCmdHandler(){
		return new CreateCorporateInfoCommandHandler( daoConfig.corpInfoDao() );
	}
	
	@Bean
	public DeleteCorporateInfoCommandHandler deleteCorporateInfoCmdHandler(){
		return new DeleteCorporateInfoCommandHandler( daoConfig.corpInfoDao() );
	}
	
	@Bean
	public EditCorporateInfoCommandHandler editCorporateInfoCmdHandler(){
		return new EditCorporateInfoCommandHandler( daoConfig.corpInfoDao() );
	}
	
	@Bean
	public CreateTutorCommandHandler createTutorCmdHandler(){
		return new CreateTutorCommandHandler( daoConfig.tutorDao() );
	}
	
	@Bean
	public DeleteTutorCommandHandler deleteTutorCmdHandler(){
		return new DeleteTutorCommandHandler( daoConfig.tutorDao() );
	}
	
	@Bean
	public EditTutorCommandHandler editTutorCmdHandler(){
		return new EditTutorCommandHandler( daoConfig.tutorDao() );
	}
	
	@Bean
	public CreateClientInfoCommandHandler createClientInfoCmdHandler(){
		return new CreateClientInfoCommandHandler( daoConfig.clientInfoDao() );
	}
	
	@Bean
	public CreateClientEnrollmentCommandHandler createClientEnrollmentCmdHandler(){
		return new CreateClientEnrollmentCommandHandler(daoConfig.clientEnrollmentDao());
	}
	
	@Bean
	public CreateLocWrkHrsCommandHandler createLocWrkHrsCmdHandler(){
		return new CreateLocWrkHrsCommandHandler(daoConfig.locationWorkHrsDao());
	}
	
	@Bean
	public CreateTutorScheduleCommandHandler createTutorScheduleCmdHandler(){
		return new CreateTutorScheduleCommandHandler(daoConfig.tutorScheduleDao());
	}
	
	@Bean
	public DeleteTutorScheduleCommandHandler deleteTutorScheduleCmdHandler(){
		return new DeleteTutorScheduleCommandHandler(daoConfig.tutorScheduleDao());
	}
	
	@Bean
	public EditTutorScheduleCommandHandler editTutorScheduleCmdHandler(){
		return new EditTutorScheduleCommandHandler(daoConfig.tutorScheduleDao());
	}
	
	@Bean
	public CreateClientSvcPkgCommandHandler createClientSvcPkgCommandHandler(){
		return new CreateClientSvcPkgCommandHandler(daoConfig.clientSvcPkgDao());
	}
	
	@Bean
	public DeleteClientSvcPkgCommandHandler deleteClientSvcPkgCommandHandler(){
		return new DeleteClientSvcPkgCommandHandler(daoConfig.clientSvcPkgDao());
	}
	
	@Bean
	public EditClientSvcPkgCommandHandler editClientSvcPkgCommandHandler(){
		return new EditClientSvcPkgCommandHandler(daoConfig.clientSvcPkgDao());
	}
	
	@Bean
	public CreateClientScheduleCommandHandler createClientScheduleCommandHandler(){
		return new CreateClientScheduleCommandHandler(daoConfig.clientScheduleInfoDao());
	}
	
	@Bean
	public DeleteClientScheduleInfoCommandHandler deleteClientScheduleCommandHandler(){
		return new DeleteClientScheduleInfoCommandHandler(daoConfig.clientScheduleInfoDao());
	}
	
	@Bean
	public CreateClientScheduleBatchCommandHandler createClientScheduleBatchCommandHandler(){
		return new CreateClientScheduleBatchCommandHandler(daoConfig.clientScheduleInfoDao());
	}
}
