package lib.service;

import lib.event.GameEvent;
import lib.model.Answer;
import lib.model.Question;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GameService extends Remote {

    //pentru game-owner
    String createGame(List<Question> questions) throws RemoteException;
    Question startGame(String gameId) throws RemoteException;
    Question nextQuestion(String gameId) throws RemoteException;

    // pentru player
    Question joinGame(String gameId) throws RemoteException;
    Question answer(Answer answer) throws RemoteException;

    // pentru server
    List<GameEvent> getEvents(String gameId) throws RemoteException;

}
