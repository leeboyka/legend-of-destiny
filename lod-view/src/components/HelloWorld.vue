<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <el-button @click="show" type="primary" size="small" round>Legends Of Destiny</el-button>
  </div>
</template>

<script>

import { getPersonInfo } from '../service/api/roleapi'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  methods: {
    show () {
      getPersonInfo({ code: '2020' }).then(res =>
        this.$message(res)
      )
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
  h3 {
    margin: 40px 0 0;
  }
</style>
