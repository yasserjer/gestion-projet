
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: true,
  baseHref: 'https://github.com/yasserjer/gestion-projet',
  locale: undefined,
  routes: undefined,
  entryPointToBrowserMapping: {
  "src/app/modules/admin/admin.module.ts": [
    {
      "path": "chunk-3KF477PN.js",
      "dynamicImport": false
    }
  ],
  "src/app/modules/etudiant/etudiant.module.ts": [
    {
      "path": "chunk-O4MVKTJA.js",
      "dynamicImport": false
    }
  ],
  "node_modules/@angular/animations/fesm2022/browser.mjs": [
    {
      "path": "chunk-QQO7GEVU.js",
      "dynamicImport": false
    }
  ]
},
  assets: {
    'index.csr.html': {size: 23720, hash: '7a76b1a23ee6e4afc70ae7987e17b87167cd63a9fdf03be5d26cb8f52fce6879', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)},
    'index.server.html': {size: 17294, hash: '028f11813e7457de5fe6e93c87f22e20b7f2b2709da79dfd4631bf953a9b22c5', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)},
    'styles-CXQUZ3PB.css': {size: 6979, hash: 'mYIPdabeAag', text: () => import('./assets-chunks/styles-CXQUZ3PB_css.mjs').then(m => m.default)}
  },
};
