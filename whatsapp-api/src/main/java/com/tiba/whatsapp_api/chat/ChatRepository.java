package com.tiba.whatsapp_api.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, String> {

    @Query("SELECT DISTINCT c FROM Chat c WHERE c.sender.id = :senderId OR c.recipient.id = :senderId ORDER BY c.createdDate DESC")
    List<Chat> findChatsBySenderId(@Param("senderId") String senderId);

    @Query("SELECT DISTINCT c FROM Chat c WHERE (c.sender.id = :senderId AND c.recipient.id = :recipientId) OR (c.sender.id = :recipientId AND c.recipient.id = :senderId) ORDER BY c.createdDate DESC")
    Optional<Chat> findChatByReceiverAndSender(@Param("senderId") String id, @Param("recipientId") String recipientId);
}
