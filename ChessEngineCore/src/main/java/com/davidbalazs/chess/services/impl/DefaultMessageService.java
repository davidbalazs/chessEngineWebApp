package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.MessageDao;
import com.davidbalazs.chess.models.MessageModel;
import com.davidbalazs.chess.services.MessageService;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by David B on 4/26/2016.
 */
public class DefaultMessageService implements MessageService {
    private MessageDao messageDao;

    @Override
    public List<MessageModel> getAll() {
        return messageDao.getAll();
    }

    @Override
    public MessageModel getById(long id) {
        return messageDao.getById(id);
    }

    @Override
    @Transactional
    public void markAsRead(long id) {
        MessageModel messageToBeMarkedAsRead = getById(id);
        messageToBeMarkedAsRead.setRead(true);
        messageDao.update(messageToBeMarkedAsRead);
    }

    @Override
    @Transactional
    public void markAsUnread(long id) {
        MessageModel messageToBeMarkedAsUnread = getById(id);
        messageToBeMarkedAsUnread.setRead(false);
        messageDao.update(messageToBeMarkedAsUnread);
    }

    @Override
    @Transactional
    public void delete(long id) {
        messageDao.delete(id);
    }

    @Override
    public void create(MessageModel message) {
        messageDao.create(message);
    }

    @Required
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
