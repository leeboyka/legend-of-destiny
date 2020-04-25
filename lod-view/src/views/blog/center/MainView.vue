<template>
  <div id="mainView">
    <el-card v-for="o in 4" :key="o" class="hot-tab-card" style="margin-bottom: 20px">
      <div class="blog-header">
        <span>
          头像、名称（会员等级等图标）、时间+快捷按钮
        </span>
      </div>
      <div class="blog-content">
        <div>列表内容</div>
        <div>配图</div>
      </div>
      <div class="blog-foot">
        <div>浏览次数+点赞、评论、收藏、转发</div>
        <el-divider></el-divider>
        <div class="lovely-list">点赞列表</div>
        <div class="comment">评论列表</div>
      </div>

    </el-card>
  </div>
</template>

<script>
export default {
  name: 'MainView'
}
</script>

<style lang="scss">
  #mainView {
    .el-card.is-always-shadow, .el-card.is-hover-shadow:focus, .el-card.is-hover-shadow:hover {
       -webkit-box-shadow: 0 2px 12px 0 rgba(0,0,0,0);
       box-shadow: 0 2px 12px 0 rgba(0,0,0,0);
    }

    .blog-header {
      /*padding-bottom: 10px;*/
    }

    .blog-content {
      padding-top: 10px;
      padding-bottom: 10px;
    }

    .blog-foot {
      .el-divider--horizontal {
        margin: 5px 0;
      }
    }
  }

</style>
