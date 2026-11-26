package com.tripsync.invitation.repository;

import com.tripsync.invitation.entity.InvitationStatus;
import com.tripsync.invitation.entity.TripInvitation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TripInvitationRepository extends JpaRepository<TripInvitation,Long> {
    List<TripInvitation> findByEmailIgnoreCase(String inviteeEmail);
    List<TripInvitation> findByTripId(Long tripId);
    Optional<TripInvitation> findByIdAndInviteeEmailIgnoreCase(Long id,String inviteeEmail);
    boolean existsByTripAndInviteeEmailIgnoreCase(Long tripId, String inviteeEmail,
                                                  InvitationStatus status);
}
