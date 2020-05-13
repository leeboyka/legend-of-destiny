<template>
    <div id="personalTab">
      <el-card class="hot-tab-card">
        <div slot="header">
          <div class="user_head">
            <div class="user_img" style="height: 50px;background-color: #2c3e50;padding-top: 20px">
              <img src="/img/avatar.278d09c7.jpg" alt="">
            </div>
          </div>
          <div class="user_title" style="margin-top: 40px">
            <h3>独孤我正邪</h3>
            <span>身负百劫刀在手，问那苍天敢负吾？</span>
          </div>
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
<style>
  .el-button--text {
    color: #606266;
  }
</style>
<style lang="scss">
#personalTab {
  .el-card__header {
    text-align: center;
  }

  .el-card__header {
    padding: 0;
  }
  .user_img img {
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 50%;
    border: 3px solid #fff;
    width: 80px;
    height: 80px;
  }
}
</style>
