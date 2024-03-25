package progII.trabalhopratico.projetofinal.BLL;

import progII.trabalhopratico.projetofinal.Entities.Client;
import progII.trabalhopratico.projetofinal.Exceptions.UserAlreadyExistsException;
import progII.trabalhopratico.projetofinal.Entities.Repository;

public class ClientBLL{
    public static void addClient(Client client) throws UserAlreadyExistsException {
        Repository repo = Repository.getInstance();
        if(repo.getClients().containsKey(client.getUsername())) {
            throw new UserAlreadyExistsException("Cliente ja existe!");
        }
        repo.getClients().put(client.getUsername(), client);
        repo.writeFile("src\\main\\resources\\Files\\repo.dat");
    }
}

