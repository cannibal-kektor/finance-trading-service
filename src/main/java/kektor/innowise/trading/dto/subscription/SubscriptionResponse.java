package kektor.innowise.trading.dto.subscription;

import kektor.innowise.trading.model.subscription.SubscriptionPlan;
import kektor.innowise.trading.model.subscription.SubscriptionStatus;

import java.time.Instant;

public record SubscriptionResponse(
        SubscriptionPlan plan,
        SubscriptionStatus status,
        Instant startsAt,
        Instant endsAt
) {
}
