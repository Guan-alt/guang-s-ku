package src;

/**
 * ClassName: SendService
 * Package: Interface
 * Dscription:短信服务接口
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:28
 */
public interface SendService {
    public int send(int count, MobileCard card);
}
