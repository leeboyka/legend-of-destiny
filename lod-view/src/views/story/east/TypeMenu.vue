<template>
  <div id="hotTab">
    <el-card class="hot-tab-card">
      <div slot="header">
        <span>作品分类</span>
      </div>
      <div v-for="o in 6" :key="o" class="text item">
        {{'列表内容 ' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'TypeMenu'
}
</script>

<style scoped>

</style>
