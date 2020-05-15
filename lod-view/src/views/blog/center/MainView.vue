<template>
  <div id="mainView">
    <el-card class="hot-tab-card" style="margin-bottom: 20px">
      <div class="edit_container">
        <p>发个博客秀一下?</p>
        <quill-editor
          v-model="content"
          ref="myQuillEditor"
          :options="editorOption"
          @focus="onEditorFocus($event)"
          @blur="onEditorBlur($event)"
          @change="onEditorChange($event)">
        </quill-editor>
      </div>
      <div class="edit_toolbar">
        <el-row type="flex" justify="space-between" align="middle">
          <span>
            <el-button type="text"><font-awesome-icon icon="smile"/> 表情</el-button>
            <el-button type="text"><font-awesome-icon icon="image"/> 图片</el-button>
            <el-button type="text"><font-awesome-icon icon="video"/> 视频</el-button>
          </span>
          <span>
            <el-dropdown>
              <el-button type="text" size="mini" style="margin-right: 15px">
                <font-awesome-icon icon="globe-asia"/> 公开<i class="el-icon-arrow-down el-icon--right"></i>
              </el-button>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item><font-awesome-icon icon="globe-asia"/> 公开</el-dropdown-item>
                <el-dropdown-item><font-awesome-icon icon="grin-hearts"/> 粉丝</el-dropdown-item>
                <el-dropdown-item><font-awesome-icon icon="user-friends"/> 好友圈</el-dropdown-item>
                <el-dropdown-item><font-awesome-icon icon="user-lock"/> 仅自己</el-dropdown-item>
                <el-dropdown-item divided><font-awesome-icon icon="user-tag"/> 指定群</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <el-button type="primary" size="mini">发布</el-button>
          </span>
        </el-row>
      </div>
    </el-card>
    <el-card v-for="o in 4" :key="o" class="hot-tab-card" style="margin-bottom: 20px">
      <div class="blog-header">
        <el-row type="flex" justify="space-between">
          <el-row type="flex" align="middle">
            <el-avatar :size="50" icon="el-icon-user-solid"></el-avatar>
            <span style="padding-left: 15px">
              独孤牧（会员等级等图标）<br>
              2020-05-01 00:00
            </span>
          </el-row>
          <el-row>
            <el-button type="text" size="mini"><font-awesome-icon icon="eye-slash"/> 屏蔽</el-button>
            <el-button type="text" size="mini"><font-awesome-icon icon="edit"/> 编辑</el-button>
            <el-button type="text" size="mini"><font-awesome-icon icon="trash"/> 删除</el-button>
          </el-row>
        </el-row>
      </div>
      <div class="blog-content">
        <div>
          晨初，天生丽质的南宫轻舞于惊艳于镜中自己的身体，不觉自慰。<br>
          又在偷看了哥哥南宫玦与继母赵小婵客厅椅上私会，后被哥哥诱骗到花园亭中意乱暧昧，在最后一刻醒悟逃离。<br>
          父南宫易天回后带一盲僧，在仔细检验过裸身的轻舞后，断定其有仙体狐阴。南宫易天便将其送与族长之子北冥惊雷为妻以示讨好，南宫轻舞不愿，离家出逃。<br>
          叶凌云练功时与父叶麟发生激烈矛盾，夜里妹妹叶芷兰偷偷探望，慰以娇躯。叶凌云欲长驱直入时，叶芷兰碍于人伦只得以腿夹、手握使之高潮。<br>
          为证实力，叶凌云只身前往巫族。叶麟派美女高手艾晴柔暗中保护，途中被叶凌云发现。内急时遭叶不准解手并被其以手指塞住阴部，最后在其挑逗下动情，与其肆意交合泄于床上。<br>
        </div>
        <div>配图</div>
      </div>
      <div class="blog-foot">
        <el-row type="flex" justify="space-between">
          <span><font-awesome-icon icon="eye"/> 浏览205次</span>
          <span>
            <el-button-group>
              <el-button type="text" size="mini" style="margin-left: 10px"><font-awesome-icon icon="thumbs-up"/> 点赞</el-button>
              <el-button type="text" size="mini" style="margin-left: 10px"><font-awesome-icon icon="comment-dots"/> 评论</el-button>
              <el-button type="text" size="mini" style="margin-left: 10px"><font-awesome-icon icon="star"/> 收藏</el-button>
              <el-button type="text" size="mini" style="margin-left: 10px"><font-awesome-icon icon="share"/> 转发</el-button>
            </el-button-group>
          </span>
        </el-row>
        <el-divider></el-divider>
        <div class="lovely-list">点赞列表</div>
        <div class="comment">评论列表</div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'MainView',
  data () {
    return {
      editor: null,
      content: '',
      editorOption: {
        modules: {
          toolbar: null
        },
        theme: 'snow',
        placeholder: ''
      }
    }
  },
  mounted () {
    this.editor = this.$refs.myQuillEditor.quill
  },
  beforeDestroy () {
    this.editor = null
    delete this.editor
  },
  methods: {
    // 准备富文本编辑器
    onEditorReady (editor) {},
    // 富文本编辑器 失去焦点事件
    onEditorBlur (editor) {},
    // 富文本编辑器 获得焦点事件
    onEditorFocus (editor) {},
    // 富文本编辑器 内容改变事件
    onEditorChange (editor) {}
  }
}
</script>
<style>
  .el-popper[x-placement^=bottom] {
     margin-top: 0;
  }
</style>
<style lang="scss">
  #mainView {
    .el-card.is-always-shadow, .el-card.is-hover-shadow:focus, .el-card.is-hover-shadow:hover {
       -webkit-box-shadow: 0 2px 12px 0 rgba(0,0,0,0);
       box-shadow: 0 2px 12px 0 rgba(0,0,0,0);
    }

    .blog-header {
      /*padding-bottom: 10px;*/
    }

    .ql-editor {
      padding: 5px 5px;
      min-height: 80px;
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
