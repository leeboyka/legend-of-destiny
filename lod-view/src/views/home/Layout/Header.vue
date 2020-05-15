<template>
  <div class="header">
    <el-header id="header">
      <ul class="menuNav">
        <li><router-link to="/">主站首页</router-link></li>
        <li><router-link to="/blog">博客社区</router-link></li>
        <li><router-link to="/story">小说漫画</router-link></li>
        <li><router-link to="/game">在线游戏</router-link></li>
        <li><router-link to="/game">私人网盘</router-link></li>
      </ul>
      <ul>
        <li>
          <el-input size="mini">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </li>
      </ul>
      <ul class="personal">
        <li>
          <el-dropdown @command="handleCommand">
            <span class="icon"><img src="../../../assets/avatar.jpg" alt=""/></span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="a"><i class="el-icon-chat-dot-round"></i>消息</el-dropdown-item>
              <el-dropdown-item command="b"><i class="el-icon-star-off"></i>关注</el-dropdown-item>
              <el-dropdown-item command="logout" divided><i class="el-icon-circle-close"></i>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </li>
        <li>大会员</li>
        <li>消息</li>
        <li>动态</li>
        <li>收藏</li>
        <li>历史</li>
        <li><router-link to="/create">创作中心</router-link></li>
      </ul>
    </el-header>
  </div>
</template>

<script>
export default {
  name: 'Header',
  methods: {
    handleCommand (command) {
      if (command === 'logout') {
        location.reload()
      }
    }
  }
}
</script>

<style lang="scss">
  $top: top;
  $bottom: bottom;
  $left: left;
  $right: right;
  $leftright: ($left, $right);
  %w100 {
    width: 100%;
  }

  %h100 {
    height: 100%;
  }

  %cursor {
    cursor: pointer;
  }

  html, body, #app, .el-container {
    @extend %h100;
  }

  @mixin set-value($side, $value) {
    @each $prop in $leftright {
      #{$side}-#{$prop}: $value;
    }
  }

  #header {
    max-height: 50px;
    line-height: 50px;
    box-shadow: 0 1px 2px 0 rgba(0, 0, 0, .05);
    display: flex;
    justify-content: space-between;

    .hideAside {
      @extend %cursor;
    }

    .menuNav {
      display: flex;
      flex-direction: row;

      li {
        @include set-value(margin, 13px);
        font-size: 12px;
      }

      .fullScreen {
        @extend %cursor;
      }

      .el-dropdown-link {
        @extend %cursor;
      }
    }

    .personal {
      display: flex;
      flex-direction: row;

      li {
        @include set-value(margin, 13px);
        font-size: 12px;
      }

      .fullScreen {
        @extend %cursor;
      }

      .el-dropdown-link {
        @extend %cursor;
      }

      .icon img {
        margin-#{$top}: 7px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 20px;
        width: 40px;
        height: 40px;
      }
    }
  }
</style>
