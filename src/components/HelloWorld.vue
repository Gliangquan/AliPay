<template>
  <div id="payDiv">
    <input
      v-model="orderInfo.oid"
      placeholder="请输入订单号"
      placeholder-class="input-placeholder"
      @input="onInput"
    />
    <input
      v-model="orderInfo.subject"
      placeholder="请输入商品名称"
      placeholder-class="input-placeholder"
      @input="onInput"
    />
    <input
      v-model="orderInfo.total"
      placeholder="请输入商品价格"
      placeholder-class="input-placeholder"
      @input="onInput"
    />
    <input
      v-model="orderInfo.desc"
      placeholder="请输入商品描述"
      placeholder-class="input-placeholder"
      @input="onInput"
    />
    <input
      v-model="orderInfo.product"
      placeholder="请输入商品ID"
      placeholder-class="input-placeholder"
      @input="onInput"
    />  
    <button type="primary" @click="payInfo">测试支付宝支付</button>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  data() {
    return {
      orderInfo: {
        "oid": "0001",
        "subject": "123456",
        "total": "100",
        "desc": "test",
        "product": "Aa001"
      }
    };
  },
  methods: {
    async payInfo() {
      const res = await axios.post('http://localhost:8081/alipay2', this.orderInfo);
      if (res.data.code === 0) {
        const div = document.createElement("div");
        div.innerHTML = res.data.data; // data就是接口返回的form 表单字符串
        const payDiv=document.getElementById("payDiv")
        payDiv.appendChild(div);
        document.forms[0].submit();
      } else {
        console.log('支付失败');
      }
    }
  }
}
</script>
