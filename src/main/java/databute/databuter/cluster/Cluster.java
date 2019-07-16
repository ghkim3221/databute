package databute.databuter.cluster;

import com.google.common.base.MoreObjects;
import databute.databuter.cluster.coordinator.ClusterCoordinator;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class Cluster {

    private ClusterCoordinator coordinator;

    private final ClusterConfiguration configuration;

    private final String id;

    public Cluster(ClusterConfiguration configuration) {
        this.configuration = checkNotNull(configuration, "configuration");
        this.id = UUID.randomUUID().toString();
    }

    public String id() {
        return id;
    }

    public void join() throws ClusterException {
        connectToCoordinator();
    }

    private void connectToCoordinator() throws ClusterException {
        coordinator = new ClusterCoordinator(this, configuration.coordinator());
        coordinator.connect();
    }

    public ClusterNode toClusterNode() {
        return new ClusterNode(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
