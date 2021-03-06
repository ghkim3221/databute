package databute.databuter.bucket.notification;

import databute.databuter.network.message.MessageSerializer;
import databute.databuter.network.packet.BufferedPacket;
import databute.databuter.network.packet.Packet;

import static com.google.common.base.Preconditions.checkNotNull;

public class BucketNotificationMessageSerializer implements MessageSerializer<BucketNotificationMessage> {

    @Override
    public Packet serialize(BucketNotificationMessage bucketNotificationMessage) {
        checkNotNull(bucketNotificationMessage, "bucketNotificationMessage");

        final Packet packet = new BufferedPacket();
        packet.writeString(bucketNotificationMessage.type().name());
        packet.writeString(bucketNotificationMessage.id());
        packet.writeInt(bucketNotificationMessage.keyFactor());
        packet.writeString(bucketNotificationMessage.activeNodeId());
        packet.writeString(bucketNotificationMessage.standbyNodeId());
        return packet;
    }
}
