<template>
  <div class="home">
    <el-container>
      <home-header></home-header>
      <el-main id="homeMain">
        <transition name="main" mode="out-in">
          <router-view></router-view>
        </transition>
      </el-main>
      <el-footer>
        <bottom></bottom>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import homeHeader from './Layout/Header'
import bottom from './Layout/Bottom'

export default {
  name: 'home',
  components: {
    homeHeader,
    bottom
  }
}
</script>

<style lang="scss">
  * {
    margin: 0;
    padding: 0;
  }

  body {
    background-color: #f2f2f2;
    font-size: 14px;
    color: #333333;
  }

  li {
    list-style: none;
  }

  a {
    text-decoration: none;
  }

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

  html, body, #loyout, .el-container, #asideNav, ul.el-menu {
    @extend %h100;
  }

  @mixin set-value($side, $value) {
    @each $prop in $leftright {
      #{$side}-#{$prop}: $value;
    }
  }

  #elmain {
    background-color: #f0f2f5;
  }

</style>
