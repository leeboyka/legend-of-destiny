<template>
    <div id="concernTab">
      <el-card class="hot-tab-card">
        <div slot="header">
          <span>我的关注</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </div>
</template>

<script>
export default {
  name: 'ConcernTab'
}
</script>

<style scoped>

</style>
