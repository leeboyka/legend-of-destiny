<template>
    <div id="personalTab">
      <el-card class="hot-tab-card">
        <div slot="header">
          <span>个人资料</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{'列表内容 ' + o }}
        </div>
        <el-button size="mini">签到</el-button>
      </el-card>
    </div>
</template>

<script>
export default {
  name: 'PersonalTab'
}
</script>

<style scoped>

</style>
