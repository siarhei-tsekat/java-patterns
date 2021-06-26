package structural.ammbassador;

/***
 * Intent
 * Provide a helper service instance on a client and offload common functionality away from a shared resource.
 *
 * An ambassador service can be thought of as an out-of-process proxy which is co-located with the client.
 * This pattern can be useful for offloading common client connectivity tasks such as monitoring, logging,
 * routing, security (such as TLS), and resiliency patterns in a language agnostic way. It is often used with legacy applications,
 * or other applications that are difficult to modify,
 * in order to extend their networking capabilities. It can also enable a specialized team to implement those features.
 *
 * Applicability
 * Ambassador is applicable when working with a legacy remote service which cannot be modified or would be extremely difficult to modify.
 * Connectivity features can be implemented on the client avoiding the need for changes on the remote service.
 *
 * Ambassador provides a local interface for a remote service.
 * Ambassador provides logging, circuit breaking, retries and security on the client.
 *
 *
 * Typical Use Case
 * Control access to another object
 * Implement logging
 * Implement circuit breaking
 * Offload remote service tasks
 * Facilitate network connection
 *
 */
public class Demo {
    public static void main(String[] args) {
        Client host1 = new Client();
        Client host2 = new Client();

        host1.useService(12);
        host2.useService(73);
    }
}
