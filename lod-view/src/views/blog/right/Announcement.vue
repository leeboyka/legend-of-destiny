<template>
    <div id="announcement">
      <el-card class="hot-tab-card">
        <div slot="header">
          <span>公告栏</span>
        </div>
        <div v-for="o in 5" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </div>
</template>

<script>
export default {
  name: 'Announcement'
}
</script>

<style scoped>

</style>
