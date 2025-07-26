package server.service;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Question;
import lib.service.GameService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GameServiceImpl extends UnicastRemoteObject implements GameService {

    public GameServiceImpl() throws RemoteException {
    }

    @Override
    public String createGame(List<Question> questions) throws RemoteException {
        return "";
    }

    @Override
    public Question startGame(String gameId) throws RemoteException {
        return null;
    }

    @Override
    public Question nextQuestion(String gameId) throws RemoteException {
        return null;
    }

    @Override
    public Question joinGame(String gameId) throws RemoteException {
        return null;
    }

    @Override
    public Question answer(Answer answer) throws RemoteException {
        return null;
    }

    @Override
    public List<GameEvent> getEvents(String gameId) throws RemoteException {
        return List.of();
    }
}
