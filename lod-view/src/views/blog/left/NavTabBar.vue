<template>
  <div id="navTabBar">
    <el-card class="hot-tab-card">
      <div slot="header" style="text-align: center">
        <font-awesome-icon icon="spider" size="4x"/>
        <p>博客社区</p>
      </div>
      <div v-for="o in 6" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'NavTabBar'
}
</script>

<style>

</style>
