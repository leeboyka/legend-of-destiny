<template>
  <div id="hotTab">
    <el-card class="hot-tab-card">
      <div slot="header">
        <span>热门推荐</span>
      </div>
      <div v-for="o in 6" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'HotTab'
}
</script>

<style scoped>

</style>
