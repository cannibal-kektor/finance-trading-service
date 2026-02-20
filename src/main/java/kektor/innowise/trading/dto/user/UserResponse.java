package kektor.innowise.trading.dto.user;

import kektor.innowise.trading.dto.subscription.SubscriptionResponse;
import kektor.innowise.trading.model.user.UserRole;
import kektor.innowise.trading.model.user.UserStatus;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        UserRole role,
        UserStatus status,
        SubscriptionResponse subscription
) {
}
