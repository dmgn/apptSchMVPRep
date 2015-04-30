package app.cal.schedule.business.cmd;

import java.util.LinkedList;
import java.util.List;
import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.business.dao.hibernate.ClientGrpDao;
import app.cal.schedule.business.entity.ClientGroup;
import app.cal.schedule.business.entity.ClientInfo;

public class CreateClientInfoCommandHandler extends BaseCommandHandler<CreateClientInfo>
		implements CommandHandler<CreateClientInfo> {

	ClientGrpDao clientGrpDao;
	
	public CreateClientInfoCommandHandler() {}
	
	public CreateClientInfoCommandHandler(ClientGrpDao clientGrpDao){
		this.clientGrpDao = clientGrpDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateClientInfo cmd) {

		final ClientGroup cgroup = new ClientGroup(cmd.getPrimContactNo(), 
				cmd.getPrimParentEmailId(),
				cmd.getSecContactNo(),
				cmd.getSecParentEmailId());
		
		List<ClientInfo> clientInfoEntity = createClientInfoEntity(cmd);
		for(ClientInfo ci : clientInfoEntity){
			ci.setClientGrp(cgroup);
		}
		cgroup.getClientInfo().addAll(clientInfoEntity);
		clientGrpDao.saveClientGrpEntity(cgroup);
		clientGrpDao.flush();
		buildResponse(ctx, cgroup, "User information saved successfully");
	}
	
	public List<ClientInfo> createClientInfoEntity(CreateClientInfo cmd){
		
		List<ClientInfoDetails> list = cmd.getClientInfo();
		List<ClientInfo> result = new LinkedList<>();
		ClientInfo clientInfoEntity = null;
		for(ClientInfoDetails element : list){
			clientInfoEntity = new ClientInfo(element.getCorpId(), element.getFirstName(), element.getLastName(), element.getDob(),
					element.getEmailId(), element.getPhoneNo());
			clientInfoEntity.auditChange();
			result.add(clientInfoEntity);
		}		
		return result;
	}

}
