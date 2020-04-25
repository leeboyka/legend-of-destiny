<template>
  <div id="mainContent">
    <el-row :gutter="20">
      <el-col :span="6" v-for="o in 12" :key="o" style="margin-bottom: 20px">
        <el-card class="hot-tab-card">
          <router-link to="/game">
            <div class="text item" style="min-height: 200px">
            </div>
          </router-link>
        </el-card>
        <div>
          {{'列表内容 ' + o }}
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'MainContent'
}
</script>

<style scoped>

</style>
