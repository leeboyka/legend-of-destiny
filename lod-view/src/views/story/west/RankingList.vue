<template>
    <div id="rankingList">
      <el-card class="hot-tab-card">
        <div slot="header">
          <span>排行榜</span>
        </div>
        <div v-for="o in 6" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
      </el-card>
    </div>
</template>

<script>
export default {
  name: 'RankingList'
}
</script>

<style scoped>

</style>
