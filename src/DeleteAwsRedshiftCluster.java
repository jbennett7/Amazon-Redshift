import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.redshift.*;
import com.amazonaws.services.redshift.model.*;

public class DeleteAwsRedshiftCluster {

    public static void main(String[] args) throws IOException {

        String endpoint = "https://redshift.us-east-1.amazonaws.com/";
        String region = "us-east-1";
        AwsClientBuilder.EndpointConfiguration config = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        AmazonRedshiftClientBuilder clientBuilder = AmazonRedshiftClientBuilder.standard();
        clientBuilder.setEndpointConfiguration(config);
        AmazonRedshift client = clientBuilder.build();

        DeleteClusterRequest request = new DeleteClusterRequest()
          .withClusterIdentifier("test-redshift");
        Cluster deleteResponse = client.deleteCluster(request);
        System.out.println("Deleted cluster " + deleteResponse.getClusterIdentifier());
    }
}
