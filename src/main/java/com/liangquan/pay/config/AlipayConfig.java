package com.liangquan.pay.config;

/**
 * @ClassName：AlipayConfig
 * @Author: liangquan
 * @Date: 2024/10/21 13:30
 * @Description: 实现的功能？
 */
public class AlipayConfig {
    // 商户appid
    public static String APPID = "9021000141623076";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCYenCgrFC3G43DvfxBso3eeasldY0ht3kWIz2w0sCB7Q/FJadozN/adbeexFaJKNDa6kS7sg/9r1OO6359jAxvhDPui0HUi3Mjq6Un5+h7oTlpNkUSssn66IG83Rn1Su8DEfslf+FN0+xx4pA2fCFrbGjenfbhIBhWlYuLsoPymksuONZaGJAc7ssY+oN6XyFiaoMwHY4ndA7YvZHw1SE4h6mM2QDvHndkFCxdaQ5Yiiid83TZrs/PuaKeTAAQ2nK1yBfhHKwZc5EPAF8h2b1FUcGOnvqZgGpb3TsWF7IHTE/KGn9y5SEU08Aufk0ad6v3AgG5znpDYm2H/1q4+FKlAgMBAAECggEAL86T6YydcgvNkwXKRb76BDsZkhEdQukHqg06lmo9uX7eZu27Y3x440HtZHYiu7Z0ZW72RfM6WEvUYwcrDaoPbBeDQNOgvEdMvm5exfhMSBbwrTA6z/YGpgioRNL+BI6OCeRlXgiOV5yOkdZ7aNnakJfY+ZOFiGhLuToCGrbJ8BI6VskO1iuyPeKmaVIVp2GvgbcL+1tRui3CITTB8bGGYwFiWYx6NC0u+PO2y1tPwY7vGcKeu0oljfeBRTnCQLKt0ChRN4+yitl+uzai0dalsW+C1khzc8yLLDESVQ5JidKTtweZnUuw4tiZCUGDpUR1jdPVBdq3d9ozPDxjj4xhsQKBgQDuO1fTkezmDzWlyFSWy3uyxZ4AnucPVE+oTdk8VPNBj45y9L4kOfQImXG7o5q0TkTPNMqep0KY5amvwsC6eBBMByM1cYYBbDw33jnoHORuCg1FuaJNNGGqlj09XwpXnfaQd6hhkmwjKk7EDdGH0lOANY/ZhERmmuyOwSfFDmXw8wKBgQCj2cUVVHkaHJzWB1XabOpsOlgGjImBmMrYFBmq/qk194P8TRGYk2K04dLuuBXgFYzBAhSMRMA5mpzj5ev1FV1H/HWGSxkoOljeCmK4fvwXw7/SH3+e8Jtl6UDs2C81VUzOzPKVBSJzsX2C22xGBQNLeMUYlwTaRDjvF5QpOiVUBwKBgD84oGYVI7kp8CK+tzQNbBZVO0kO4mK/DSStBCluod+UKUl4ib0zY/+kOPqCwFt5KemTKPJRkOrih9WM6XiSxEBo5H8aUWWvQ4vP/a4LfNN29265hMjYTdLna/kNb8Ewum48UwMRyIDMiXqd8C0LM/2iOTqQT1arZnu75sH0wDjhAoGAQLNinryfoY8A44c8AKeXnisfzV47gkBqgQ7W3+31tYjKxptMQnqYtKKj334zrSv1S9XddVJEsbp7D4cgOMQ59I4dfm0zPu5jXzKsrvv94gh7O6cShxmt031bFOt9IMtRLCxD8lJ3u0WwMTciNzgNiATll4My+FmOPeOKrwj16osCgYBGCSlp+p3wun3/ZP+5yWOHuASiy/dbFWXVDSXxFlGXPWV3Vepj7XEXqnj8fpQ9rmbLkVyzMSza9YQMv0a42VSlsIdr0z+eQ83D3to1vny4NDDi7sSfu7S8TJOpl1tJclwPsaeKKsYebvCedfA1y4Ji9Wfv1qcgThylzseqTEdyZw==";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8088/pay/page/notify";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8081/return.html";
    // 请求网关地址 https://openapi-sandbox.dl.alipaydev.com/gateway.do
    public static String URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAstHqsOcPTI+KJhObXhs48Dnni9RpV9zBM5aMAm1vtJCSIW8dOsorQ/pz3kcisYPGcwGnqN9V3WxAdlms5Uumpi7OQ8At94Nb+xgoZp4cP9aN4MjEIc2lKTpDAqMtOUMZjK/LS/Ml67/qvi9XpunZ3G/drm9YaQ4VOX19Kc6+QZxK0/5vpzfc9nw1GtIJwcwv26VKJQJs5fz/OHu58BwNw3uGvIaB5xs70i9KV5bMQpj2teUAV437AfbUeG6vAsdnzieYzzr8q4wSyxkydoHvL6urBc1Gn3a0GQUoNfQEFhTh06dfXCzmlAdO6kJql4oxjRSC2zPBnXiH/mcD5zyU3wIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
