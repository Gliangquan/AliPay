<template>
  <div id="payDiv">
    <el-button type="primary" @click="payInfo">测试支付宝支付</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orderInfo: {
        "oid": "lisi",
        "subject": "123456",
        "total": "100",
        "desc": "test",
        "product": "a11111"
      }
    };
  },
//方法集合
  methods: {
    async payInfo() {
      const {data: resp} = await this.$http.post('/alipay'
          , this.orderInfo)
      if (resp.code === 200) {
        const div = document.createElement("div");
        div.innerHTML = resp.data; // data就是接口返回的form 表单字符串
        const payDiv = document.getElementById("payDiv")
        payDiv.appendChild(div);
// document.forms[0].setAttribute("target", "_blank"); // 新开窗口
        跳转
        document.forms[0].submit();
      }
    },
  }
}
</script>