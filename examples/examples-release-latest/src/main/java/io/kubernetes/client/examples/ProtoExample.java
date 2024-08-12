/*
Copyright 2020 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.examples;

import io.kubernetes.client.ProtoClient;
import io.kubernetes.client.ProtoClient.ObjectOrStatus;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.proto.Meta.ObjectMeta;
import io.kubernetes.client.proto.V1.Namespace;
import io.kubernetes.client.proto.V1.NamespaceSpec;
import io.kubernetes.client.proto.V1.Pod;
import io.kubernetes.client.proto.V1.PodList;
import io.kubernetes.client.util.Config;
import java.io.IOException;

/**
 * A simple example of how to use the Java API
 *
 * <p>Easiest way to run this: mvn exec:java
 * -Dexec.mainClass="io.kubernetes.client.examples.ProtoExample"
 *
 * <p>From inside $REPO_DIR/examples
 */
public class ProtoExample {
  public static void main(String[] args) throws IOException, ApiException, InterruptedException {
    ApiClient client = new ApiClient();
    client.setBasePath("https://5302E4D20BD5556D8BE3B85E635F1DAE.gr7.ap-northeast-2.eks.amazonaws.com");
    client.setApiKey("Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6InF5a2NsWElJMjNZTlNNRU03X3V4eERkd0NYcmZNbEhTZjZnb2gyQXFvYlkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImNsb2l0LWRldi1zZWNyZXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiY2xvaXQtZGV2LXNhIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiY2U1MzVlMWYtNzM1ZC00YjVjLTk0MTAtZTRlMDhjY2RjY2QzIiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRlZmF1bHQ6Y2xvaXQtZGV2LXNhIn0.olP2AXIFQ0OydTWNPr_PMBUqVVAMmCwqPZXMpkSQI7jGl65MDDMioovk4-t9prxAhN0ZbTJ4hAeKuD7UvuvNy3AHj5qXDpZ80e7NoZIAIKXqmN_IxtSv9bkU3cwbH5V-yocGVj_oBm8Ok0LuTXPLO0NYlo5gbt8nJdBNCBhGTqOnLgjpARwJV6I2xuOTft4Zbs-CGbO7aYd4_e_drBIz8jdI_lEtB7JnydS_3zzUlOKGya2ZiEfxN-gXrherBuvvDRPT7GaG4Aj9HLaNLTl0Hz8staKUvshhJuE4WjKuCilILSL1D2mE0TPS3BBBP0BSXFRKiHsarZndo5L7Z-0VxQ");
    client.setVerifyingSsl(false);
    Configuration.setDefaultApiClient(client);

    ProtoClient pc = new ProtoClient(client);
    ObjectOrStatus<PodList> list = pc.list(PodList.newBuilder(), "/api/v1/namespaces/default/pods");

    if (list.object.getItemsCount() > 0) {
      Pod p = list.object.getItems(0);
      System.out.println(p);
    }

    Namespace namespace =
        Namespace.newBuilder().setMetadata(ObjectMeta.newBuilder().setName("test").build()).build();

    ObjectOrStatus<Namespace> ns = pc.create(namespace, "/api/v1/namespaces", "v1", "Namespace");
    System.out.println(ns);
    if (ns.object != null) {
      namespace =
          ns.object
              .toBuilder()
              .setSpec(NamespaceSpec.newBuilder().addFinalizers("test").build())
              .build();
      // This is how you would update an object, but you can't actually
      // update namespaces, so this returns a 405
      ns = pc.update(namespace, "/api/v1/namespaces/test", "v1", "Namespace");
      System.out.println(ns.status);
    }

    ns = pc.delete(Namespace.newBuilder(), "/api/v1/namespaces/test");
    System.out.println(ns);
  }
}
